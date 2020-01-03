package com.cafeatte.main;

public class Execute {
	// 서비스를 실행하는 메서드 작성 -> 객체를 따로 만들어 주는 것이 좋겠다.
	// service(실행 객체, 넘겨질 파라메터) -> 넘겨질 파라메터는 알맞게 캐스팅해서 사용하는 것으로 한다.
	public static Object service(Service service, Object... objs) throws Exception {
		return service.service(objs);
	}
	
}
