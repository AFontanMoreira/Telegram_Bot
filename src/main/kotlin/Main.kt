import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.command
import com.github.kotlintelegrambot.entities.ChatId
import com.github.kotlintelegrambot.entities.ParseMode

/**
* EL Bicho es un Bot de Telegram creado en Kotlin
* Para su funcionamiento se ha usado la librería:
* https://github.com/kotlin-telegram-bot/kotlin-telegram-bot
* @version 1.0, 01/06/21
* @author Alexander Fontán
*/

fun main() {
    println("hola mundo")

    val excusa1 = "Lo siento me encuentro mal hoy, no voy a poder ir a clase"
    val excusa2 = "Me duele la cabeza, no voy a poder ir a clase"
    val excusa3 = "Oh, pensaba que hoy les tocaba al otro crupo"
    val excusa4 = "Nah sin mas no me apetecia ir"
    val excusa5 = "Me duele el dedo meñique del pie"
    val excusas = arrayOf<String>(excusa1,excusa2,excusa3,excusa4,excusa5)



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
                    */excusa* | Genera una excusa para un nuevo dia
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

            /**
             * Comando /desaparecer
             *
             * Javi desaparece de clase
             */

            command("desaparecer"){
                val respuestaDesaparecer = bot.sendMessage(chatId = ChatId.fromId(update.message!!.chat.id), text = "Espera que hago en clase. Me largooooo!!!!")
                val respuestaDesaparecer2 = bot.sendAnimation(chatId = ChatId.fromId(update.message!!.chat.id), "https://media.tenor.com/images/83da5b25bd710dda7ce487ee322895c1/tenor.gif" )
            }

            /**
             *Comando /justificante
             *
             * Envio de un justificante para faltar a clase
             */

            command("justificante"){
                val respuestaJustificante = bot.sendMessage(chatId = ChatId.fromId(update.message!!.chat.id), text = "Aqui tiene su justificante para poder faltar hoy. Imprimalo las veces que lo necesite.")
                val respuestaJustificante2 = bot.sendPhoto(chatId = ChatId.fromId(update.message!!.chat.id), "https://loentiendo.com/wp-content/uploads/2015/11/nuevo-sistema-bajas-medicas.jpg")
            }

            /**
             * Comando /excusa
             *
             * genera una excusa aleatoria
             */

            command("excusa"){

                val nRandom = (0..4).random()
                val respuestaExcusa = bot.sendMessage(chatId = ChatId.fromId(update.message!!.chat.id), text = excusas[nRandom])

            }

        }

    }
    bot.startPolling()
}