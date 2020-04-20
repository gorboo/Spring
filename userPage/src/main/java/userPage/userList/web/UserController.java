package userPage.userList.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.annotation.Resource;

import org.mindrot.jbcrypt.BCrypt;
/*import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
*/
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springmodules.validation.commons.DefaultBeanValidator;

import userPage.type.GrantType;
import userPage.userList.service.*;

@Controller
public class UserController {
	
	@Resource(name = "userService")
	private UserService userService;
	
	/** Validator */
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;

	@RequestMapping(value = "/userPage.userList.do")
	public String userList(@ModelAttribute("userVO") UserVO userVO, ModelMap model) throws Exception {
		try {
			List<UserVO> userList = userService.selectUserList(userVO);
			for(UserVO uVo : userList) {
				String userType = uVo.getUserType();
				uVo.setUserType(GrantType.valueOf(Integer.parseInt(userType)).getName());
			}
			model.addAttribute("resultList", userList);
		} catch (Exception e) {
			System.out.println("error Message : "+e.getMessage());
			System.out.println(e.getStackTrace().toString());
		}
		return "userPage/userList";
	}
	
	@RequestMapping(value = "/userPage.userRegist.do")
	public String userDetail(@ModelAttribute("userVO")  UserVO userVO, Model model, SessionStatus status) {
		model.addAttribute("userVO", new UserVO());
	    return  "userPage/userRegist";
	}
	
	@RequestMapping(value = "/userPage.addUser.do")
	public String addUser(@ModelAttribute("userVO")  UserVO userVO, BindingResult bindingResult, Model model, SessionStatus status) 
	throws Exception {
		String uuid = UUID.randomUUID().toString();
		userVO.setObid(uuid);
		userVO.setCreatedOn(new Date());
		userVO.setPwd(BCrypt.hashpw(userVO.getPwd(), BCrypt.gensalt()));
		// Server-Side Validation
		beanValidator.validate(userVO, bindingResult);
		
		userService.insertUser(userVO);
		status.setComplete();
		
	    return  "forward:/userPage.userList.do";
	}
	
	@RequestMapping("/userPage.userModify.do")
	public String updateUserView(@RequestParam("selectedId") String id, @ModelAttribute("searchVO") UserVO userVO, Model model) throws Exception {
		UserVO searchVO = new UserVO();
		searchVO.setObid(id);
		// 변수명은 CoC 에 따라 sampleVO
		model.addAttribute(selectUser(searchVO, userVO));
		return "userPage/userRegist";
	}

	public UserVO selectUser(UserVO userVO, @ModelAttribute("searchVO") UserVO searchVO) throws Exception {
		return userService.selectUser(userVO);
	}
	
	@RequestMapping("/userPage.updateUser.do")
	public String updateUser(@ModelAttribute("searchVO") UserVO searchVO, UserVO userVO, BindingResult bindingResult, Model model, SessionStatus status)
			throws Exception {
		System.out.println("updateUser");
		beanValidator.validate(userVO, bindingResult);
		
		userVO.setModifiedOn(new Date());
		if(userVO.getPwd() != null || userVO.getPwd() != "") {
			userVO.setPwd(BCrypt.hashpw(userVO.getPwd(), BCrypt.gensalt()));
		}

		userService.updateUser(userVO);
		status.setComplete();
		return "forward:/userPage.userList.do";
	}

	@RequestMapping("/userPage.deleteUser.do")
	public String deleteUser(UserVO userVO, @ModelAttribute("searchVO") UserVO searchVO, SessionStatus status) throws Exception {
		System.out.println("deleteUser");
		System.out.println(userVO.getObid());
		userService.deleteUser(userVO);
		status.setComplete();
		return "forward:/userPage.userList.do";
	}
}
