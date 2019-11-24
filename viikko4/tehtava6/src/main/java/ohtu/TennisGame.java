package ohtu;

public class TennisGame {
    
    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == player1Name) {
            player1Score += 1;
        } else {
            player2Score += 1;
        }
    }

    public String getScore() {
         
        if (player1Score == player2Score) {
            return evenScore(player1Score);
        } else if (player1Score>=4 || player2Score>=4) {
            return highScore(player1Score, player2Score);
        } 

        return getPointName(player1Score) + "-" + getPointName(player2Score);                                            
    }

    private String evenScore(int m_score1) {
        if (m_score1 < 4) {
            return getPointName(m_score1) + "-All";
        }

        return "Deuce";
    }

    private String highScore(int m_score1, int m_score2) {
        int scoreDifference = m_score1-m_score2;
        String leaderName;

        if (Math.abs(scoreDifference) == 1) {
            if (m_score1 > m_score2) {
                leaderName = player1Name;
            } else {
                leaderName = player2Name;
            }

            return "Advantage " + leaderName;            
    
        } else {
            if (m_score1 > m_score2) {
                leaderName = player1Name;
            } else {
                leaderName = player2Name;
            }

            return "Win for " + leaderName;
        }
    }


    private String getPointName(int points) {
        String pointName = "";
        if (points == 0) {
            pointName = "Love";
        } else if (points == 1) {
            pointName = "Fifteen";
        } else if (points == 2) {
            pointName = "Thirty";
        } else if (points == 3) {
            pointName = "Forty";
        }
        
        return pointName;
    }

}