package userPage.type;

import java.util.EnumSet;

public enum GrantType {
	ADMIN(1, "관리자"),
	NUSER(2, "일반 사용자");
	
	private int code;

	private String text;

	private GrantType(int code, String text) {
		this.code = code;
		this.text = text;
	}

	public int getCode() {
		return code;
	}

	public String getName() {
		return text;
	}

	@Override
	public String toString() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public static GrantType valueOf(int code) {
		for (GrantType statusType : EnumSet.allOf(GrantType.class)) {
			if (statusType.code == code) {
				return statusType;
			}
		}
		throw new IllegalArgumentException(Integer.toString(code));
	}

}
