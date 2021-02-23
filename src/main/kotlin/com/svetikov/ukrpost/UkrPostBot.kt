package com.svetikov.ukrpost

import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendDocument
import org.telegram.telegrambots.meta.api.methods.send.SendLocation
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow

class UkrPostBot : TelegramLongPollingBot() {
    override fun getBotUsername(): String = "ukrPostSvetikovbot"

    override fun getBotToken(): String = "1623432679:AAFvnFmrrApJJke__7pHr9RUT0ozYU8PnkU"

    override fun onUpdateReceived(update: Update) {
        val keyBoard = ReplyKeyboardMarkup()
        keyBoard.keyboard = listOf(
            KeyboardRow().apply {
                add(KeyboardButton("/start"))
            }
        )

        if (update.hasMessage()) {
            when (update.message.text) {
                "/start2" -> sendOneMessage2(
                    update, "Радий тебе знов бачити ${update.message.from.firstName}", listOf(
                        ButtonSetting("Вибір регіональної філії", "kiev_1"),
                        ButtonSetting("Київ", "kiev_2"),
                        ButtonSetting("На початок ", "/start")

                    )
                )
                "/start" -> sendOneMessage2(
                    update,
                    "Вітаю Тебе ${update.message.from.firstName}",
                    listOf(ButtonSetting("Далі", "next_0"))
                )
            }
        }

        if (update.hasCallbackQuery()) {
            when (update.callbackQuery.data) {
                "/start" -> sendOneMessage(
                    update,
                    "Вітаю Тебе ${update.callbackQuery.from.firstName}",
                    listOf(ButtonSetting("Далі", "next_0"))
                )

                "next_0" -> sendOneMessage(
                    update, "Я твій помічник і допоможу тобі корисною інформацією", listOf(
                        ButtonSetting("Далі", "next_1")
                    )
                )
                "next_1" -> sendOneMessage(
                    update, "Тож тобі необхідно взяти у відділі кадрів перелік наступних документів",
                    listOf(ButtonSetting("Далі", "next_2"))
                )

                "next_2" -> sendOneMessage(
                    update, "Оформлення в офісі за адрессою", listOf(
                        ButtonSetting("Вибір регіональної філії", "kiev_1"),
                        ButtonSetting("Київ", "kiev_2"),
                     //   ButtonSetting("KIEV3", "kiev_3")
                    )
                )
                //
                "kiev_1" -> sendOneMessage(
                    update, "Офіс у регіонах",
                    listOf(
                        ButtonSetting("Вінниця", "info_about_office_1_Вінниця"),
                        ButtonSetting("Луцьк", "info_about_office_1_Луцьк"),
                        ButtonSetting("Дніпро", "info_about_office_1_Дніпро"),
                        ButtonSetting("Житомир", "info_about_office_1_Житомир"),
                        ButtonSetting("Івано-Франківськ", "info_about_office_1_Івано-Франківськ"),
                        ButtonSetting("Львів", "info_about_office_1_Львів")
                    )
                )
                "info_about_office_1_Вінниця" -> sendOneMessage(
                    update, "вул. Соборна, 59, м. Вінниця, 21100 Контактний місцевий телефон: (0432) 67 00 11",
                    listOf(
                        ButtonSetting("Далі", "next_5")
                    )
                )
                "info_about_office_1_Луцьк" -> sendOneMessage(
                    update,
                    "вул. Кривий Вал, 19, м. Луцьк, 43025 Контактний місцевий телефон: (0332) 72 23 12 volinska-d@ukrposhta.ua",
                    listOf(
                        ButtonSetting("Далі", "next_5")
                    )
                )
                "info_about_office_1_Дніпро" -> sendOneMessage(
                    update, "просп. Дмитра Яворницького, 62, м. Дніпро, 49000\n" +
                            "\n" +
                            "Контактний місцевий телефон: (056) 374 96 77\n" +
                            "\n" +
                            "Еmail: dnipropetrovska-d@ukrposhta.ua",
                    listOf(
                        ButtonSetting("Далі", "next_5")
                    )
                )
                "info_about_office_1_Житомир" -> sendOneMessage(
                    update, "вул. Вітрука, 1, м. Житомир, 10001\n" +
                            "\n" +
                            "Контактний місцевий телефон: (0412) 41 11 24, (0412) 41 87 10\n" +
                            "\n" +
                            "Контактний корпоративний мобільний телефон: (067) 412 35 77",
                    listOf(
                        ButtonSetting("Далі", "next_5")
                    )
                )
                "info_about_office_1_Івано-Франківськ" -> sendOneMessage(
                    update, "вул. Незалежності, 6, м. Івано-Франківськ, 76018\n" +
                            "\n" +
                            "Контактний місцевий телефон: (0342) 53 04 63\n" +
                            "\n" +
                            "Факс: (0342) 53 22 98\n" +
                            "\n" +
                            "Еmail: ivanofrankivska-d@ukrposhta.ua",
                    listOf(
                        ButtonSetting("Далі", "next_5")
                    )
                )
                "info_about_office_1_Львів" -> sendOneMessage(
                    update, "вул. Словацького, 1, м. Львів, 79000\n" +
                            "\n" +
                            "Контактний місцевий телефон: (032) 297 03 28\n" +
                            "\n" +
                            "Факс: (032) 276 48 26\n" +
                            "\n" +
                            "Еmail: lvivska-d@ukrposhta.ua",
                    listOf(
                        ButtonSetting("Далі", "next_5")
                    )
                )



                "kiev_2" -> sendOneMessage(
                    update, "Офіс у Київі", listOf(
                        ButtonSetting("КМД", "info_about_office_2"),
                        ButtonSetting("ЦАУ", "info_about_office_3")
                    )
                )

                "info_about_office_2" -> sendOneMessage(  // TODO: 23.02.2021 office info
                    update, " м.Київ вул.Хрищятик,22 (Головпоштамп) тел. (044)230 08 20", listOf(
                        ButtonSetting("Далі", "next_5"),
                        ButtonSetting("Розташування на мапі", "map_1")
                    )
                )
                "map_1" -> sendMapMessage(
                    update,  50.4498457f, 30.5229698f, listOf( //todo map 1
                        ButtonSetting("Далі", "next_5")
                    )
                )
                "info_about_office_3" -> sendOneMessage(
                    update, " м.Київ вул.Хрищятик,22 тел. (044)230 08 20", listOf(
                        ButtonSetting("Далі", "next_5"),
                        ButtonSetting("Розташування на мапі", "map_2")
                    )
                )
                "map_2" -> sendMapMessage(
                    update,  50.4498457f, 30.5229698f, listOf( //todo map 2
                        ButtonSetting("Далі", "next_5")
                    )
                )
                "next_5" -> sendOneMessage(
                    update, "Тепер залишилось тільки під'їхати в віділ кадрів з необхідними документами." +
                            "Рекрутер повідомить тобі про твій перший робочий день", listOf(
                        ButtonSetting("Далі", "next_6")
                    )
                )
                "next_6" -> sendOneMessage(
                    update, "А я допоможу тобі швидше зорієнтуватися в задачах. Тож до зустрічі!",
                    listOf(
                        ButtonSetting("Далі", "end"),
                        ButtonSetting("На початок", "/start")
                    )
                )
                "end" -> sendOneMessage(
                    update, "Вітаю тебе з першим робочим днем ${update.callbackQuery.from.firstName}", listOf(
                        ButtonSetting("doc","doc")
                    )
                )
                "doc"->sendDocumentMessage(update,"jetbrains://idea/navigate/reference?project=ukr-post&path=static/document")


            }
        }

    }

    private fun sendOneMessage(update: Update, setText: String, buttonSetting: List<ButtonSetting>) {
        execute(
            SendMessage()
                .setChatId(update.callbackQuery.message.chatId)
                .setText(setText)
                .setReplyMarkup(InlineKeyboardMarkup().apply {
                    keyboard = listOf(
                        buttonSetting.map { InlineKeyboardButton(it.message).apply { callbackData = it.destination } }
                    )
                })
        )
    }

    private fun sendOneMessage2(update: Update, setText: String, buttonSetting: List<ButtonSetting>) {
        execute(
            SendMessage()
                .setChatId(update.message.chatId)
                .setText(setText)
                .setReplyMarkup(InlineKeyboardMarkup().apply {
                    keyboard = listOf(
                        buttonSetting.map { InlineKeyboardButton(it.message).apply { callbackData = it.destination } }
                    )
                })
        )
    }

    private fun sendMapMessage(update: Update,latitude: Float,longitude: Float,buttonSetting: List<ButtonSetting>) {
        execute(
            SendLocation()
                .setChatId(update.callbackQuery.message.chatId)
                .setLatitude(latitude)
                .setLongitude(longitude)

                .setReplyMarkup(InlineKeyboardMarkup().apply {
                    keyboard = listOf(
                        buttonSetting.map { InlineKeyboardButton(it.message).apply { callbackData = it.destination } }
                    )
                })
        )
    }

    private fun sendDocumentMessage(update: Update,document:String){
        execute(
            SendDocument()
                .setChatId(update.callbackQuery.message.chatId)
                .setDocument(document)
                .setCaption("Documents")
        )
    }
}