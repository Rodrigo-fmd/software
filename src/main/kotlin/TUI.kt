import isel.leic.utils.Time

fun main() {
    HAL.init()
    HAL.setBits(0x02)
    HAL.clrBits(0x02)
    HAL.writeBits(0x08, 0x03)
    KBD.init()
    LCD.init()
    SerialEmitter.init()
    LCD.clear()
    LCD.cursor(1,2)
    LCD.write("C")
    Time.sleep(1000)
    LCD.cursor(0,5)
    LCD.write("a")
    Time.sleep(1000)
    LCD.cursor(1,5)
    LCD.write("r")
    LCD.clear()
    SerialEmitter.send(SerialEmitter.Destination.LCD, 0x23, 8)
    Time.sleep(1000)
    SerialEmitter.send(SerialEmitter.Destination.SCORE, 0x56, 7)
}