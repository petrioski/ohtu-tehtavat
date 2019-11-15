
package ohtu;

public class Player implements Comparable<Player> {
    private String name;
    private String team;
    private String nationality;
    private int goals;
    private int assists;


    public void setName(String name, String team, String nationality, int goals, int assits) {
        this.name = name;
        this.team = team;
        this.nationality = nationality;
        this.goals = goals;
        this.assists = assits;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return goals + assists;
    }

    /**
     * @return the nationality
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * @return the assists
     */
    public int getAssists() {
        return assists;
    }

    /**
     * @return the team
     */
    public String getTeam() {
        return team;
    }

    /**
     * @return the goals
     */
    public int getGoals() {
        return goals;
    }

    @Override
    public String toString() {
        return name 
                + " " + team 
                + " " + goals 
                + " + " + assists
                + " = " + this.getPoints();
    }

    @Override
    public int compareTo(Player o) {
        return o.getPoints() - this.getPoints();
    }

}
