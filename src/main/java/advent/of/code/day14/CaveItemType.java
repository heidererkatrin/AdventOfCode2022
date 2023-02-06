package advent.of.code.day14;


public enum CaveItemType {
    AIR("."),
    STONE("#"),
    SAND("o"),
    SAND_ORIGIN("+");

    final String code;

    CaveItemType(String code) {
        this.code = code;
    }

}
