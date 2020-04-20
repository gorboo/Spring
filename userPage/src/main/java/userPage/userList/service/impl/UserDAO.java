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

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import userPage.userList.service.UserVO;

import org.springframework.stereotype.Repository;

@Repository("userDAO")
public class UserDAO extends EgovAbstractDAO {

	/**
	 * 사용자를 등록한다.
	 * @param vo - 등록할 정보가 담긴 UserVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	public String insertUser(UserDAO vo) throws Exception {
		return (String) insert("uesrDAO.insertUser", vo);
	}

	/**
	 * 사용자를 수정한다.
	 * @param vo - 수정할 정보가 담긴 UserVO
	 * @return void형
	 * @exception Exception
	 */
	public void updateUser(UserVO vo) throws Exception {
		update("uesrDAO.updateUser", vo);
	}

	/**
	 * 사용자를 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 UserVO
	 * @return void형
	 * @exception Exception
	 */
	public void deleteUser(UserVO vo) throws Exception {
		delete("uesrDAO.deleteUser", vo);
	}

	/**
	 * 사용자를 조회한다.
	 * @param vo - 조회할 정보가 담긴 UserVO
	 * @return 조회한 사용자
	 * @exception Exception
	 */
	public UserVO selectUser(UserVO vo) throws Exception {
		return (UserVO) select("uesrDAO.selectUser", vo);
	}

	/**
	 *사용자를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return 사용자 목록
	 * @exception Exception
	 */
	public List<?> selectUserList(UserVO searchVO) throws Exception {
		System.out.println("come here2");
		return list("uesrDAO.selectUserList", searchVO);
	}



}
