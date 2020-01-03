/**
 * 페이지 처리를 위한 객체
 * - 페이지 처리
 * 작성일 : 2019-11-28
 * 작성자 : 안지혜
 */

package com.cafeatte.util.page;

public class PageObject {

	// java 부분의 페이지 처리를 위한 변수
	// 현재 페이지
	private int page;
	// 한 페이지에 표시할 데이터의 갯수
	private int perPageNum;
	// 시작번호와 끝번호
	private int startRow;
	private int endRow;

	// jsp 부분에서 페이지 전환을 위한 변수
	// 전체 데이터의 갯수 - dao에서 count(*)로 계산 - service에서 데이터 셋팅
	// setter/getter 둘다 필요
	private int totalRow;
	// 전체 페이지 : totalRow 데이터가 들어오면 자동으로 계산하도록 한다. setTotalRow()작성
	// getter만 필요
	private int totalPage;
	// 하단 부분의 페이지 링크부분(페이지네이션)에 나타날 페이지의 갯수 -> perGroupPageNum
	private int perGroupPageNum;
	

	// 페이지 그룹에 나타나는 처음와 끝 페이지 - 현재 페이지에 따라 다른게 설정된다.
	// totalPage가 나오면 계산할 수 있다. - totalPage가 25면 endPage가 30으로 셋팅되는 경우
	// - endPage가 totalPage를 넘는 경우는 endPage를 totalPage로 변경
	private int startPage;
	private int endPage;
	
	//============검색에 필요한 데이터 변수
	private String key;
	private String word;

	// 기본 값을 셋팅하기 위한 기본 생성자
	public PageObject() {
		// 페이지 기본 값 :1, 페이지 당 데이터 갯수 :10(개발자가 정한다)
		// start, endRow는 계산을 통해 설정
		this(1, 10);// 밑에 선언한 PageObject(int page, int perPageNum)로 기본 설정
//		this.page = 1;
//		this.perPageNum = 10;
	}

	// 현재 페이지와 한 페이지당 표시하는 데이터의 갯수를 전달받아서 처리한다.
	public PageObject(int page, int perPageNum) {
		// 현재 페이지와 한 페이지당 표시하는 데이터의 갯수를 전달받아서 처리한다.
		this(page, perPageNum, 10);
	}

	// 현재 페이지와 한 페이지 당 표시하는 데이터의 갯수를 *전달 받아서* 처리한다.
	public PageObject(int page, int perPageNum, int perGroupPageNum) {
		// 페이지 기본 값 :1, 페이지 당 데이터 갯수 :10(개발자가 정한다)
		// start, endRow는 계산을 통해 설정
		this.page = page;
		this.perPageNum = perPageNum;
		this.perGroupPageNum = perGroupPageNum;

		// 현재 페이지의 시작 줄 번호 구하기((page-1)*perPageNum+1)
		this.startRow = (page - 1) * perPageNum + 1;
		// 끝 줄번호 = 시작 줄번호에 한 페이지당 표시하는 데이터의 갯수를 더하면 다음 페이지의 시작 번호가 되는데
		// 여기서 1을 빼면 현재 페이지의 마지막 번호가 된다. (startRow + perPageNum -1)
		// (this.startRow + perPageNum - 1) == (page * perPageNum)
		this.endRow = this.startRow + perPageNum - 1;
	}

	public int getPage() {
		return page;
	}

	// 리스트 표시 요청이 있을 때 마다 새로운 pageObject 객체가 생성되기 때문에 처리하는 동안에는 변경되지 않는다.
	// 그래서 setter가 필요 없다.
	// 생성자에서 데이터를 처리하도록 작성한다.
//	public void setPage(int page) {
//		this.page = page;
//	}

	public int getPerPageNum() {
		return perPageNum;
	}
	
	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}

	public int getStartRow() {
		return startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public int getTotalRow() {
		return totalRow;
	}

	// 전체 데이터의 갯수가 정해지면 전체 페이지를 구할 수 있다.
	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
		this.totalPage = (totalRow - 1) / perPageNum + 1;
		// 시작페이지
		this.startPage = (page - 1) / perGroupPageNum * perGroupPageNum + 1;
		// 끝페이지
		this.endPage = startPage + perGroupPageNum - 1;
		// 끝페이지가 전체 페이지 보다 큰 경우 조정
		if(endPage > totalPage)
			this.endPage = totalPage;
	}

	public int getTotalPage() {
		return totalPage;
	}
	
	public int getPerGroupPageNum() {
		return perGroupPageNum;
	}
	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word.trim();
	}

	@Override
	public String toString() {
		return "PageObject [page=" + page + ", perPageNum=" + perPageNum + ", startRow=" + startRow + ", endRow="
				+ endRow + ", totalRow=" + totalRow + ", totalPage=" + totalPage + ", perGroupPageNum="
				+ perGroupPageNum + ", startPage=" + startPage + ", endPage=" + endPage + ", key=" + key + ", word="
				+ word + "]";
	}

	// page 문자열과 perPageNum 문자열 받아서 객체를 생성해주는 메서드
	public static PageObject getInstance(String strPage, String strPerPageNum) {
		PageObject pageObject = null;

		// 처음 게시판으로 들어오거나, 페이지 데이터가 넘어오지 않으면 1페이지로 간주한다. : 기본 생성자 사용
		if (strPage == null || strPage.equals("")) {
			pageObject = new PageObject(); // page:1, perPageNum:10 기본 셋팅
		} else {
			int page = Integer.parseInt(strPage);
			// 한 페이지당 데이터 갯수가 넘어오지 않는 경우 기본 값으로 처리
			if (strPerPageNum == null || strPerPageNum.equals("")) {
				strPerPageNum = "10";
			}
			// 넘어오면 넘어온 데이터로 처리
			int perPageNum = Integer.parseInt(strPerPageNum);
			pageObject = new PageObject(page, perPageNum);
		}
		System.out.println("PageObject.getInstance().pageObject: " + pageObject);
		return pageObject;
	}
	// page 문자열과 perPageNum 문자열 받아서 객체를 생성해주는 메서드
	public static PageObject getInstanceMagazine(String strPage, String strPerPageNum) {
		PageObject pageObject = null;
		
		// 처음 게시판으로 들어오거나, 페이지 데이터가 넘어오지 않으면 1페이지로 간주한다. : 기본 생성자 사용
		if (strPage == null || strPage.equals("")) {
			pageObject = new PageObject(1, 12); // page:1, perPageNum:10 기본 셋팅
		} else {
			int page = Integer.parseInt(strPage);
			// 한 페이지당 데이터 갯수가 넘어오지 않는 경우 기본 값으로 처리
			if (strPerPageNum == null || strPerPageNum.equals("")) {
				strPerPageNum = "12";
			}
			// 넘어오면 넘어온 데이터로 처리
			int perPageNum = Integer.parseInt(strPerPageNum);
			pageObject = new PageObject(page, perPageNum);
		}
		System.out.println("PageObject.getInstance().pageObject: " + pageObject);
		return pageObject;
	}
	

}
