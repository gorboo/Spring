/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package userPage.userList.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import userPage.userList.service.UserService;
import userPage.userList.service.UserVO;

/**
 * @Class Name : EgovSampleServiceImpl.java
 * @Description : Sample Business Implement Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2009.03.16           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2009. 03.16
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */

@Service("userService")
public class UserImpl extends EgovAbstractServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserImpl.class);

	/** userDAO */
	// TODO ibatis 사용
	//@Resource(name = "userDAO")
	//private UserDAO userDAO;
	// TODO mybatis 사용
	@Resource(name="userMapper")
	private UserMapper userDAO;

	@Override
	public String insertUser(UserVO vo) throws Exception {
		LOGGER.debug(vo.toString());
		userDAO.insertUser(vo);
		return null;
	}

	@Override
	public void updateUser(UserVO vo) throws Exception {
		LOGGER.debug(vo.toString());
		userDAO.updateUser(vo);
	}

	@Override
	public void deleteUser(UserVO vo) throws Exception {
		LOGGER.debug(vo.toString());
		userDAO.deleteUser(vo);
	}

	@Override
	public UserVO selectUser(UserVO vo) throws Exception {
		UserVO resultVO = userDAO.selectUser(vo);
		if (resultVO == null)
			throw processException("info.nodata.msg");
		return resultVO;
	}

	@Override
	public List<UserVO> selectUserList(UserVO searchVO) throws Exception {
		System.out.println("come here");
		return (List<UserVO>) userDAO.selectUserList(searchVO);
	}

	

}
