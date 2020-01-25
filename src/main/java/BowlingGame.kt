class BowlingGame {

    private fun convertScoreToNumber(s: String) : Int {
        return  when (s) {
            "X" -> 10 // strike
            "/" -> 10 // spare
            "-" -> 0
            else -> { s.toInt() }
        }
    }

    fun score(input: String): Int {
        var rolls : List<String> = input.split("").filter {it != " " && it != ""}

        var result = 0

        for (i in rolls.indices){
            var roll = rolls[i]

            // If towards the end, check the edge case of ending the game with spare(s)
            if (rolls.size - 3 <= i) {
                // If a spare, then find out how many pins were actually knocked down in this roll
                if (roll == "/") {
                    result += (10 - convertScoreToNumber(rolls[i-1]))
                }
                else {
                    result += convertScoreToNumber(roll)
                }
            }

            // If strike, add 10 and the next 2 rolls
            else if (roll == "X") {
                result += 10

                // If the 2nd roll was a spare, then add 10
                if (rolls[i+2] == "/") {
                    result += 10
                }
                else {
                    result += convertScoreToNumber(rolls[i+1])
                    result += convertScoreToNumber(rolls[i+2])
                }
            }

            // If spare, add 10 and the next roll
            else if (roll == "/") {
                result += (10 - convertScoreToNumber(rolls[i-1]))
                result += convertScoreToNumber(rolls[i+1])
            }

            // If just a number, add it up
            else {
                result += convertScoreToNumber(roll)
            }
        }
        return result;
    }
}


