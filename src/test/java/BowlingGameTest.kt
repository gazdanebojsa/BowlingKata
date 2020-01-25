import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class BowlingGameTest {

    private val bowlingGame = BowlingGame()

    private val testData = arrayOf(
        "X X X X X X X X X XXX",
        "X -/ X 5- 8/ 9- X 81 1- 4/X",
        "62 71 X 9- 8/ X X 35 72 5/8",
        "X 7/ 72 9/ X X X 23 6/ 7/3",
        "X X X X 9/ X X 9/ 9/ XXX",
        "8/ 54 9- X X 5/ 53 63 9/ 9/X",
        "X 7/ 9- X -8 8/ -6 X X X81",
        "X 9/ 5/ 72 X X X 9- 8/ 9/X",
        "X -/ X X X X X X X XXX",
        "X 1/ X X X X X X X XXX",
        "X 2/ X X X X X X X XXX",
        "X 3/ X X X X X X X XXX",
        "X 4/ X X X X X X X XXX",
        "X 5/ X X X X X X X XXX",
        "X 6/ X X X X X X X XXX",
        "X 7/ X X X X X X X XXX",
        "X 8/ X X X X X X X XXX",
        "X 9/ X X X X X X X XXX",
        "-/ X X X X X X X X XX-",
        "1/ X X X X X X X X XX-",
        "2/ X X X X X X X X XX-",
        "3/ X X X X X X X X XX-",
        "4/ X X X X X X X X XX-",
        "5/ X X X X X X X X XX-",
        "6/ X X X X X X X X XX-",
        "7/ X X X X X X X X XX-",
        "8/ X X X X X X X X XX-",
        "9/ X X X X X X X X XX-",
        "X X X X X X X X X X-/",
        "X X X X X X X X X X18",
        "X X X X X X X X X X26",
        "X X X X X X X X X X34",
        "X X X X X X X X X X42",
        "X X X X X X X X X X5-",
        "-/ X X X X X X X X XX1",
        "1/ X X X X X X X X XX1",
        "2/ X X X X X X X X XX1",
        "3/ X X X X X X X X XX1",
        "4/ X X X X X X X X XX1",
        "5/ X X X X X X X X XX1",
        "6/ X X X X X X X X XX1",
        "7/ X X X X X X X X XX1",
        "8/ X X X X X X X X XX1",
        "9/ X X X X X X X X XX1",
        "X X X X X X X X X X1/",
        "X X X X X X X X X X27",
        "X X X X X X X X X X35",
        "X X X X X X X X X X43",
        "X X X X X X X X X X51"
    );

    private val testResults = arrayOf(
        300,
        137,
        140,
        168,
        247,
        149,
        167,
        187,
        280,
        280,
        280,
        280,
        280,
        280,
        280,
        280,
        280,
        280,
        280,
        280,
        280,
        280,
        280,
        280,
        280,
        280,
        280,
        280,
        280,
        280,
        280,
        280,
        280,
        280,
        281,
        281,
        281,
        281,
        281,
        281,
        281,
        281,
        281,
        281,
        281,
        281,
        281,
        281,
        281
    )

    @Test
    fun `test bulk`() {
        for (i in testData.indices) {
            val score = bowlingGame.score(testData[i]);
            assertThat(score).isEqualTo(testResults[i]);
        }
    }

    @Test
    fun `all strikes`() {
        val score = bowlingGame.score("X X X X X X X X X X X X")
        assertThat(score).isEqualTo(300)
    }

    @Test
    fun `every second pin a miss`() {
        val score = bowlingGame.score("9- 9- 9- 9- 9- 9- 9- 9- 9- 9-")
        assertThat(score).isEqualTo(90)
    }

    @Test
    fun `my test`() {
        val score = bowlingGame.score("62 71 X 9- 8/ X X 35 72 5/8")
        assertThat(score).isEqualTo(140)
    }

    @Test
    fun `all spares`() {
        val score = bowlingGame.score("5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/5")
        assertThat(score).isEqualTo(150)
    }
}