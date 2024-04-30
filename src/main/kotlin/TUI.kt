import isel.leic.utils.Time

fun main() {
    HAL.init()
    KBD.init()
    LCD.init()
    LCD.clear()
    LCD.write("C")
    Time.sleep(1000)
    LCD.cursor(0,5)
    LCD.write("a")
    Time.sleep(1000)
    LCD.cursor(1,5)
    LCD.clear()
}