/*
 * Copyright 2011 MOPAS(Ministry of Public Administration and Security).
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

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import userPage.userList.service.UserVO;

/**
 * User에 관한 데이터처리 매퍼 클래스
 *
 * @author  표준프레임워크센터
 * @since 2014.01.24
 * @version 1.0
 * @see <pre>
 *  == 개정이력(Modification Information) ==
 *
 *          수정일          수정자           수정내용
 *  ----------------    ------------    ---------------------------
 *   2014.01.24        표준프레임워크센터          최초 생성
 *
 * </pre>
 */
@Mapper("userMapper")
public interface UserMapper {

	/**
	 * user 목록을 조회한다.
	 * @param UserVO - 조회할 정보가 담긴 VO
	 * @return 글 목록
	 * @exception Exception
	 */
	List<?> selectUserList(UserVO searchVO) throws Exception;
	
	/**
	 * 신규 사용자를 등록한다.
	 * @param UserVO - 등록할 정보가 담긴 VO
	 * @return 글 목록
	 * @exception Exception
	 */
	void insertUser(UserVO vo) throws Exception;
	
	UserVO selectUser(UserVO vo) throws Exception;
	
	void updateUser(UserVO vo) throws Exception;
	
	void deleteUser(UserVO vo) throws Exception;
	
}
