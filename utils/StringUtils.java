package utils;

public class StringUtils {
	
	/**
	 * 지정된 텍스트의 줄바꿈문자를 br 태그로 변경한 텍스트를 반환한다.
	 * @param text 텍스트
	 * @return 줄바꿈 문자로 br 태그로 변경된 문자열
	 */

	public static String withBr(String text) {
		if(text == null) {
			return "";
		}
		return text.replace(System.lineSeparator(), "<br>");
		//lineSeparator 줄바꿈 문자를 말함
	}
}
