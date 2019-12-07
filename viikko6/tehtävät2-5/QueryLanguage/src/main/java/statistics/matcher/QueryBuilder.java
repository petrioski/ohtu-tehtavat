package statistics.matcher;


public class QueryBuilder {
    Matcher matcher;
    
    public QueryBuilder() {
        Matcher m = new All();
        this.matcher = new All();                
    }

    // public QueryBuilder And(Matcher... matchers) {
    //     this.matcher = new And(matchers);
    //     return this;
    // }

    public QueryBuilder playsIn(String team) {
        this.matcher = new And(this.matcher, new PlaysIn(team));
        return this;
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        this.matcher = new And(this.matcher, new HasAtLeast(value, category));
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        this.matcher = new And(this.matcher, new HasFewerThan(value, category));
        return this;
    }

    public Matcher build() {
        return matcher;
    }
}