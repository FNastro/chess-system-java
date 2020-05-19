package BoardGame;

public class Board {
	
	private int row;
	private int columns;
	private Piece [] [] pieces;
	
	
	public Board(int row, int columns) {
		if(row < 1 || columns < 1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
		}
		this.row = row;
		this.columns = columns;
		pieces = new Piece [row] [columns];
	}


	public int getRow() {
		return row;
	}

	public int getColumns() {
		return columns;
	}

	public Piece piece(int row, int column) {
		if (!positionExist(row, column)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		if (!positionExist(position)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	private boolean positionExist(int row, int column) {
		return row >= 0 && row < this.row && column >= 0 && column < columns;
	}
	
	public boolean positionExist(Position position) {
		
		return positionExist(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsAPiece (Position position) {
		if (!positionExist(position)) {
			throw new BoardException("Position not on the board");
		}
		return piece(position) != null;
	}
}
