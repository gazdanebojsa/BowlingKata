import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class NoBonusFrameTest {

    @Test
    fun `return pins`() {
        val noBonusFrame = NoBonusFrame("12")

        assertThat(noBonusFrame.pins).isEqualTo(listOf(1, 2))
    }

    @Test
    fun `regular frame sums pins`() {
        val noBonusFrame = NoBonusFrame("12")
        val score = noBonusFrame.score(nextPins = noBonusFrame.pins)

        assertThat(score).isEqualTo(3)
    }

    @Test
    fun `regular frame below 10 points`() {
        val noBonusFrame = NoBonusFrame("34")

        assertThat(noBonusFrame.pins).isEqualTo(listOf(3, 4))
    }

    @Test
    fun `regular frame with spare`() {
        val noBonusFrame = NoBonusFrame("3/6")

        assertThat(noBonusFrame.pins).isEqualTo(listOf(3, 7, 6))
    }

    @Test
    fun `regular frame with spare and strike`() {
        val noBonusFrame = NoBonusFrame("3/X")

        assertThat(noBonusFrame.pins).isEqualTo(listOf(3, 7, 10))
    }

    @Test
    fun `regular frame with strikes`() {
        val noBonusFrame = NoBonusFrame("XXX")

        assertThat(noBonusFrame.pins).isEqualTo(listOf(10, 10, 10))
    }
}