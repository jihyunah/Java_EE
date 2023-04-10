package board.bean;

import lombok.Data;

@Data	// @Data - setter / getter / public BoardPaging(){}  / - toString() / equals() / hashCode()
public class BoardPaging {
	private int currentPage;//현재페이지
	private int pageBlock;//[이전][1][2][3][다음]
	private int pageSize;//1페이지당 5개씩
	private int totalA;//총글수
	private StringBuffer pagingHTML;	//String은 편집이 안되기 떄문에 String대신 StringBuffer를 대신해서 쓴다.
	
	public void makePagingHTML() {
		pagingHTML = new StringBuffer();
		
		int totalP = (totalA + 4) / pageSize;//총 페이지 수
		
		int startPage = (currentPage-1) / pageBlock * pageBlock + 1;
		
		int endPage = startPage + pageBlock - 1;
		
		if(endPage > totalP) endPage = totalP;
		
		if(startPage > pageBlock) {	//혹은 startPage != 1로도 사용가능
			pagingHTML.append("<span id='paging' onclick='boardPaging("+(startPage-1)+")'>[이전]</span>");
		}
		
		for(int i=startPage; i<=endPage; i++) {
			if(i==currentPage)
				pagingHTML.append("<span id='currentPaging'>" + i + "</span>");
			else
				pagingHTML.append("<span id='paging' onclick='boardPaging("+(i)+")'>" + i + "</span>");
		}
		
		if(endPage < totalP) {
			pagingHTML.append("<span id='paging' onclick='boardPaging("+(endPage+1)+")'>[다음]</span>");
		}
		
		
	}
}
