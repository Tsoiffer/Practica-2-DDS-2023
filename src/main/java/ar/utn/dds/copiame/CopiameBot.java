package ar.utn.dds.copiame;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class CopiameBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
// Esta función se invocará cuando nuestro bot reciba un mensaje
// Se obtiene el mensaje escrito por el usuario
        final String messageTextReceived = update.getMessage().getText();
// Se obtiene el id de chat del usuario
        Long chatId = update.getMessage().getChatId();
// Se crea un objeto mensaje
        SendMessage message = new SendMessage();
        message.setChatId(chatId.toString());
        message.setText(messageTextReceived);
        try {
// Se envía el mensaje
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    @Override
    public String getBotUsername() {
// Se devuelve el nombre que dimos al bot al crearlo con el BotFather
        return "copiame_tsoiffer_bot";
    }
    @Override
    public String getBotToken() {
// Se devuelve el token que nos generó el BotFather de nuestro bot
        return "6037887730:AAFqgpEHilS2qxGXTtomZlD-MFouyt_g7gQ";
    }
    public static void main(String[] args)
            throws TelegramApiException {
// Se crea un nuevo Bot API
        final TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        try {
// Se registra el bot
            telegramBotsApi.registerBot(new CopiameBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}
