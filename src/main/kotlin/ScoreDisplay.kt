object ScoreDisplay { // Controla o mostrador de pontuação.
    // Inicia a classe, estabelecendo os valores iniciais.
    fun init(){
        setScore(0)
    }
    // Envia comando para atualizar o valor do mostrador de pontuação
    fun setScore(value: Int){
        // Convert the score to a binary representation
        // Send the binary score to the score display using the SerialEmitter
        SerialEmitter.send(SerialEmitter.Destination.SCORE, value, 7)
    }
    // Envia comando para desativar/ativar a visualização do mostrador de pontuação
    fun off(value: Boolean){
        if(value){
            // Send a command to turn off the score display
            SerialEmitter.send(SerialEmitter.Destination.SCORE, 1, 1)
        } else {
            // Send a command to turn on the score display
            SerialEmitter.send(SerialEmitter.Destination.SCORE, 0, 1)
        }
    }
}