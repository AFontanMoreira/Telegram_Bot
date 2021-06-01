import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.command
import com.github.kotlintelegrambot.dispatcher.text
import com.github.kotlintelegrambot.entities.ChatId
import com.github.kotlintelegrambot.entities.ParseMode


fun main(args: Array<String>) {
    println("hola mundo")

    val bot = bot {
        token = Apikey.mitoken

        dispatch {

            /**
             * Comando /help
             *
             * Descripcion y listado de los comandos
             */

            command("help"){

                val help = """
                    */saludo* | Javi se presenta
                    */justificante* | Envia justificante
                    */desaparecer* | Javi desaparece de clase
                    */excusa* | Genera una escusa para un nuevo dia
                    """.trimIndent()
                bot.sendMessage(
                    chatId = ChatId.fromId(message.chat.id),
                    text = help,
                    parseMode = ParseMode.MARKDOWN
                )
            }
            /**
             * Comando /saludo
             *
             * Javi te saluda renegando su apodo
             */

            command("saludo"){
                val respuestaSaludo = bot.sendMessage(chatId = ChatId.fromId(update.message!!.chat.id), text = "Hey soy Javi, aun que a veces me llamen Cristian, nos vemos en clase")
            }

        }

    }
    bot.startPolling()
}