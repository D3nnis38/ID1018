public class ReachableFieldsOnChessboard {

    public static void main(String[] args) throws NoSuchFieldException, InterruptedException {
        Chessboard cb = new Chessboard();

        Chessboard.Chesspiece[] pieces = new Chessboard.Chesspiece[] {
                cb.new Pawn  ('w'),
                cb.new Rook  ('b'),
                cb.new Queen ('w'),
                cb.new Bishop('w'),
                cb.new King  ('b'),
                cb.new Knight('w')
        };

        for (int i = 0; i < pieces.length; i++) {
            pieces[i].moveToRandom();
            pieces[i].markReachableFields();
            System.out.println(cb);
            pieces[i].unmarkReachableFields();
            pieces[i].moveOut();
        }
    }

}
