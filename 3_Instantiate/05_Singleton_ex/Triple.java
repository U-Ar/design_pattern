public enum Triple {
    ALPHA,BETA,GAMMA;

    public static Triple getInstance(String name) {
        /*if (name == "ALPHA") return Triple.ALPHA;
        else if (name == "BETA") return Triple.BETA;
        else return Triple.GAMMA;*/
        return valueOf(name);
    }
}