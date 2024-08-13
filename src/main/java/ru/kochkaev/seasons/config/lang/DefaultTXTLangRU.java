package ru.kochkaev.seasons.config.lang;

import ru.kochkaev.api.seasons.config.Config;
import ru.kochkaev.api.seasons.object.TXTConfigObject;

public class DefaultTXTLangRU extends TXTConfigObject {
    
    public DefaultTXTLangRU() {
        super("Seasons Challenges", "RU_ru", "lang");
    }

    public void generate() {

        String copyright = Config.getCopyright() + "#\n# It's mod lang!\n#" +
                "\n# ** NAME = Display name of the Weather/Season\n# ** MESSAGE = Message, sends to chat on trigger\n#\n# Placeholders:\n#   - %season% - replaces to current season.\n" +
                "#   - %weather% - replaces to current weather.\n#   - & - replaces to \"§\" (colour codes).\n#\n# Other config files:\n#   - current.json - information about the current Weather/Season,\n#     is updated when the server is turned off.\n#   - lang - directory, contains translations of mod names/messages.\n\n\n";
        addString(copyright);

        /// SEASON
        addComment("* SEASON");
        // Winter
        addComment("Winter");
        addValueAndCommentDefault("lang.season.winter.name", "&bЗима");
        addValueAndCommentDefault("lang.season.winter.message", "&eДа свершится новогоднее чудо! Наступила %season%");
        // Spring
        addComment("Spring");
        addValueAndCommentDefault("lang.season.spring.name", "&2Весна");
        addValueAndCommentDefault("lang.season.spring.message", "&eС глаз долой весь снег! Наступила %season%");
        // Summer
        addComment("Summer");
        addValueAndCommentDefault("lang.season.summer.name", "&aЛето");
        addValueAndCommentDefault("lang.season.summer.message", "&eНастало время пекла! Наступило %season%");
        // Fall
        addComment("Fall");
        addValueAndCommentDefault("lang.season.fall.name", "&6Осень");
        addValueAndCommentDefault("lang.season.fall.message", "&eУнылая пора! Очей очарованье! Наступила %season%");

        /// WEATHER
        addVoid();
        addComment("* WEATHER");
        // Night
        addComment("Night");
        addValueAndCommentDefault("lang.weather.night.name", "&7Ночь");
        addValueAndCommentDefault("lang.weather.night.message", "&7Кажется темнеет... Наступает %weather%");
        // Snowy
        addComment("Snowy");
        addValueAndCommentDefault("lang.weather.snowy.name", "&7Снежно");
        addValueAndCommentDefault("lang.weather.snowy.message", "&7Белый туман одеялом ложится на крыши и цветы. Сегодня %weather%");
        // Freezing
        addComment("Freezing");
        addValueAndCommentDefault("lang.weather.freezing.name", "&9Морозно");
        addValueAndCommentDefault("lang.weather.freezing.message", "&3Вся вода замерзает! Сегодня %weather%");
        // Stormy
        addComment("Stormy");
        addValueAndCommentDefault("lang.weather.stormy.name", "&cШторм");
        addValueAndCommentDefault("lang.weather.stormy.message", "&cГремит январская вьюга! Сегодня %weather%");
        // Cold
        addComment("Cold");
        addValueAndCommentDefault("lang.weather.cold.name", "&9Холодно");
        addValueAndCommentDefault("lang.weather.cold.message", "&3На окнах появляется иней. Сегодня %weather%");
        // Warm
        addComment("Warm");
        addValueAndCommentDefault("lang.weather.warm.name", "&eТепло");
        addValueAndCommentDefault("lang.weather.warm.message", "&eПриятный тёплый ветерок обдувает вас. Сегодня %weather%");
        // Hot
        addComment("Hot");
        addValueAndCommentDefault("lang.weather.hot.name", "&eЖарко");
        addValueAndCommentDefault("lang.weather.hot.message", "&eНас как в печку поместили! Сегодня %weather%");
        // Scorching
        addComment("Scorching");
        addValueAndCommentDefault("lang.weather.scorching.name", "&eНевыносимо жарко");
        addValueAndCommentDefault("lang.weather.scorching.message", "&eСейчас на улице такое пекло, что кожа слазит. Сегодня %weather%");
        // Rainy
        addComment("Rainy");
        addValueAndCommentDefault("lang.weather.rainy.name", "&9Дождливо");
        addValueAndCommentDefault("lang.weather.rainy.message", "&3Вы лицезреете сильнейший ливень! Сегодня %weather%");
        // Chilly
        addComment("Chilly");
        addValueAndCommentDefault("lang.weather.chilly.name", "&9Прохладно");
        addValueAndCommentDefault("lang.weather.chilly.message", "&3Вы дрожите от холода! Сегодня %weather%");
        // Breezy
        addComment("Breezy");
        addValueAndCommentDefault("lang.weather.breezy.name", "&7Свежо");
        addValueAndCommentDefault("lang.weather.breezy.message", "&7Вас обдувает лёгкий ветерок. Сегодня %weather%");
        // Beautiful
        addComment("Beautiful");
        addValueAndCommentDefault("lang.weather.beautiful.name", "&aКрасиво");
        addValueAndCommentDefault("lang.weather.beautiful.message", "&aСолнце светит, жизнь прекрасна! Сегодня %weather%");

        /// CHALLENGES
        addVoid();
        addComment("* CHALLENGES");
        // Feels good
        addComment("Feels good");
        addValueAndCommentDefault("lang.effect.feelsGood.message.trigger", "&aThe breeze feels so good on your skin, armour would just ruin the effect...");
        addValueAndCommentDefault("lang.effect.feelsGood.message.get", "&aThe sun on your skin without armour gives you energy, Feels Good!");
        addValueAndCommentDefault("lang.effect.feelsGood.message.remove", "&eAs you leave the world behind, the energising sunlight wears off...");
        // Fluffy Coat
        addComment("Fluffy Coat");
        addValueAndCommentDefault("lang.effect.fluffyCoat.message.trigger", "&aYour armour gives you a soothing warmth, making you resistant to the harsh cold!");
        addValueAndCommentDefault("lang.effect.fluffyCoat.message.get", "&aYour armour gives you a soothing warmth and makes you more Resistant to the world");
        addValueAndCommentDefault("lang.effect.fluffyCoat.message.remove", "&cWithout armour, your body feels the cold once again and is no longer resistant to it");
        // Primitive Heating
        addComment("Primitive Heating");
        addValueAndCommentDefault("lang.effect.primitiveHeating.message.trigger", "&9A source of heat would be great to carry around in this cold!");
        addValueAndCommentDefault("lang.effect.primitiveHeating.message.get", "&aA hot item in your inventory warms your heart and makes you Resistant to the cold world");
        addValueAndCommentDefault("lang.effect.primitiveHeating.message.remove", "&eYour body is no longer warmed and its Resistance wears away...");
        // Revitalized
        addComment("Revitalized");
        addValueAndCommentDefault("lang.effect.revitalized.message.trigger", "&aThis weather is so revitalizing!");
        addValueAndCommentDefault("lang.effect.revitalized.message.get", "&aThe sun from this world is so &eRevitalising&a, it is Regenerating you!");
        addValueAndCommentDefault("lang.effect.revitalized.message.remove", "&eAs the light of the world light leaves your skin, the &6Revitalising &eenergy leaves too...");
        // Warming Stew
        addComment("Warming Stew");
        addValueAndCommentDefault("lang.effect.warmingStew.message.trigger", "&7Your stomach starts to grumble and you begin to crave some hearty soup...");
        addValueAndCommentDefault("lang.effect.warmingStew.message.get", "&aThat hit the spot, the delicious stew makes your wounds a little more bearable...");
        // Wind In Your Boots
        addComment("Wind In Your Boots");
        addValueAndCommentDefault("lang.effect.windInYourBoots.message.trigger", "&7You feel the wind in your favour today!");
        addValueAndCommentDefault("lang.effect.windInYourBoots.message.get", "&aYou feel a rush of Wind in your Boots and go hurtling forwards!");
        // Devastation
        addComment("Devastation");
        addValueAndCommentDefault("lang.effect.devastation.message.trigger", "&cYour hearts beats rapidly, yours legs tremble and you find you cannot regenerate health until this Devastation passes!");
        // Frostbite
        addComment("Frostbite");
        addValueAndCommentDefault("lang.effect.frostbite.message.trigger", "&cThe world is freezing over and so will you if you fail to get armour on!");
        // Hold Onto Your Hat
        addComment("Hold Onto Your Hat");
        addValueAndCommentDefault("lang.effect.holdOntoYourHat.message.trigger", "&7Be careful with your hat, the wind is getting up...");
        addValueAndCommentDefault("lang.effect.holdOntoYourHat.message.get", "&eYour hat just blew off, oh dear!");
        // Hot Sand
        addComment("Hot Sand");
        addValueAndCommentDefault("lang.effect.hotSand.message.trigger", "&eWalking on sand in this heat must be painful!");
        addValueAndCommentDefault("lang.effect.hotSand.message.get", "&eAuch! Sand is too hot!");
        // Icy
        addComment("Icy");
        addValueAndCommentDefault("lang.effect.icy.message.trigger", "&9A chill runs down your spine as water turns to ice!");
        addValueAndCommentDefault("lang.effect.icy.message.get", "&cThe water freezes in your bucket...");
        // Soldering Iron
        addComment("Soldering Iron");
        addValueAndCommentDefault("lang.effect.solderingIron.message.trigger", "&eThe nearby iron starts to sizzle, better put it down for now...");
        addValueAndCommentDefault("lang.effect.solderingIron.message.get", "&cThe iron is soldering hot, try not to hold it for too long!");
        // Strong Current
        addComment("Strong Current");
        addValueAndCommentDefault("lang.effect.strongCurrent.message.trigger", "&9The water flows with a strong current, it will be hard to wade through!");
        addValueAndCommentDefault("lang.effect.strongCurrent.message.get", "&cThe current crashes against you and your muscles cry in pain...");
        addValueAndCommentDefault("lang.effect.strongCurrent.message.remove", "&aSeasickness passes, the waters no longer bother you...");
        // Sweating
        addComment("Sweating");
        addValueAndCommentDefault("lang.effect.sweating.message.trigger", "&eThis is most definitely NOT the weather for full armour...");
        addValueAndCommentDefault("lang.effect.sweating.message.get", "&cSweat drips from your forehead, it is too Hot for armour today...");
        addValueAndCommentDefault("lang.effect.sweating.message.remove", "&aThe air turns cooler and you wipe the sweat from your forehead...");
        // The Shivers
        addComment("The Shivers");
        addValueAndCommentDefault("lang.effect.theShivers.message.trigger", "&cThe water is near ice and dangerously cold to the touch...");
        addValueAndCommentDefault("lang.effect.theShivers.message.get", "&cThe freezing water is killing you, get out of it if you want to live!");
        // Wet Mud
        addComment("Wet Mud");
        addValueAndCommentDefault("lang.effect.wetMud.message.trigger", "&7The dirt coats your boots and becomes hard to move through in this weather...");
        addValueAndCommentDefault("lang.effect.wetMud.message.get", "&eThe mud sticks to your boots, slowing you down...");
    }
}
