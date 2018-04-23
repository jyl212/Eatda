package dto;

import java.sql.Date;

public class BoardDTO {

    private int boardNo;

    private String id;

    private int idState;

    private Date writeDate;

    private String boardTitle;

    private String boardContent;

    private String boardState;

    private String publicCheck;

    private int boardCount;

    private String boardPw;

	public BoardDTO(int boardNo, String id, int idState, Date writeDate, String boardTitle, String boardContent,
			String boardState, String publicCheck, int boardCount, String boardPw) {
		super();
		this.boardNo = boardNo;
		this.id = id;
		this.idState = idState;
		this.writeDate = writeDate;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardState = boardState;
		this.publicCheck = publicCheck;
		this.boardCount = boardCount;
		this.boardPw = boardPw;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getIdState() {
		return idState;
	}

	public void setIdState(int idState) {
		this.idState = idState;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardState() {
		return boardState;
	}

	public void setBoardState(String boardState) {
		this.boardState = boardState;
	}

	public String getPublicCheck() {
		return publicCheck;
	}

	public void setPublicCheck(String publicCheck) {
		this.publicCheck = publicCheck;
	}

	public int getBoardCount() {
		return boardCount;
	}

	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}

	public String getBoardPw() {
		return boardPw;
	}

	public void setBoardPw(String boardPw) {
		this.boardPw = boardPw;
	}
    
    
}