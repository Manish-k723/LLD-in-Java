package TicTacToeLLD.Model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public enum PieceTypeMapping {
    X(new PlayingPiece(PieceType.X)),
    O(new PlayingPiece(PieceType.O)),
    D(new PlayingPiece(PieceType.D)),
    Y(new PlayingPiece(PieceType.Y));

    private final PlayingPiece piece;
    private static final Map<String, PieceTypeMapping> SYMBOL_MAP = new HashMap<>();

    static {
        for (PieceTypeMapping mapping : PieceTypeMapping.values()) {
            SYMBOL_MAP.put(mapping.name(), mapping);
        }
    }

    PieceTypeMapping(PlayingPiece piece) {
        this.piece = piece;
    }

    public PlayingPiece getPiece() {
        return piece;
    }

    public static PlayingPiece fromSymbol(String symbol) {
        PieceTypeMapping mapping = SYMBOL_MAP.get(symbol.toUpperCase());
        return (mapping != null) ? mapping.getPiece() : null;
    }
    public static Set<String> getPlayingPieces(){
        return SYMBOL_MAP.keySet();
    }
}
