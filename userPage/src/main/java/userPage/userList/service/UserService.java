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
package userPage.userList.service;

import java.util.List;


public interface UserService {

	/**
	 * 사용자를 등록한다.
	 * @param vo - 등록할 정보가 담긴 userVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	String insertUser(UserVO vo) throws Exception;

	/**
	 * 사용자를 수정한다.
	 * @param vo - 수정할 정보가 담긴 userVO
	 * @return void형
	 * @exception Exception
	 */
	void updateUser(UserVO vo) throws Exception;

	/**
	 * 사용자를 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 userVO
	 * @return void형
	 * @exception Exception
	 */
	void deleteUser(UserVO vo) throws Exception;

	/**
	 * 사용자를 조회한다.
	 * @param vo - 조회할 정보가 담긴 userVO
	 * @return 조회한 글
	 * @exception Exception
	 */
	UserVO selectUser(UserVO vo) throws Exception;
	
	/**
	 * 사용자 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return 사용자 목록
	 * @exception Exception
	 */
	List<UserVO> selectUserList(UserVO searchVO) throws Exception;

}
