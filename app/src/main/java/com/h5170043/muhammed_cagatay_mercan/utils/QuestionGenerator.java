package com.h5170043.muhammed_cagatay_mercan.utils;

import com.h5170043.muhammed_cagatay_mercan.model.Question;

public class QuestionGenerator {

    public static Question getQuestionByCategoryName(Category name, int index){
        if (name == Category.Science){
            return scienceQuestions[index];
        } else {
            return techQuestions[index];
        }
    }

    public static int getTotalQuestionNumber(Category name){
        if (name == Category.Science){
            return scienceQuestions.length;
        } else {
            return techQuestions.length;
        }
    }

    private static final Question[] scienceQuestions = new Question[]{
            new Question("İnsan nefesi eksi kaç derecede donar?",
                    "-90",
                    new String[]{"-10", "-40", "-60", "-90"}),
            new Question("İnsanın kaşını kaldırabilmesi için kaç kası oynar?",
                    "30",
                    new String[]{"10", "20", "30", "40"}),
            new Question("Ortalama insan beyni ne kadar ağırlıktadır?",
                    "6.5kg",
                    new String[]{"5kg", "5.5kg", "6kg", "6.5kg"}),
            new Question("Kangurular bir sıçrayışta ne kadar yükseğe çıkarlar?",
                    "3-4 metre",
                    new String[]{"3-4 metre", "4-5 metre", "5-6 metre", "6-7 metre"}),
            new Question("Bir insan günde ne kadar hava tüketir?",
                    "28 bin litre",
                    new String[]{"25 bin litre", "28 bin litre", "30 bin litre", "33 bin litre"}),
            new Question("Dünya'ya kadar uzanan havasız, sürtünmesiz bir delikten düştüyseniz, diğer tarafa düşmek ne kadar sürer? (Dakika)",
                    "42",
                    new String[]{"15", "25", "42", "63"}),
            new Question("Ahtapotun kaç kalbi var?",
                    "3",
                    new String[]{"1", "2", "3", "4"}),
            new Question("Dünyada insan başına ne kadar su var?",
                    "210,000,000,000 litre",
                    new String[]{"210,000,000,000 litre", "210,000,000 litre", "120,000,000,000 litre", "120,000,000 litre"})
    };

    private static final Question[] techQuestions = new Question[]{
            new Question("Apple firması ne zaman kurulmuştur?",
                    "1976",
                    new String[]{"1965", "1976", "1981", "1998"}),
            new Question("1 Bayt kaç bittir?",
                    "8",
                    new String[]{"2", "4", "6", "8"}),
            new Question("Aşağıdaki işlemlerden hangisi dijital bankacılık kanalı ile yapılamaz?",
                    "Noter kağıtları satış ödemesi",
                    new String[]{"Noter kağıtları satış ödemesi", "SGK ödemeleri", "HGS ve OGS bakiye güncelleme", "Trafik cezası ödemeleri"}),
            new Question("Bağlı olduğu öge hakkında bilgi içeren, ödeme, para çekme gibi işlemleri " +
                    "kolayca yapabildiğimiz optik etikete ne denir?",
                    "QR Kod",
                    new String[]{"Sesli Komut", "QR Kod", "Kızılötesi (Infrared) Bağlantı", "Dijital Çip"}),
            new Question("Bitcoin gibi kripto paralarda kullanılan, ticarette ve gündelik hayatta güvenilir ve " +
                    "hızlı olması ile büyük avantajlar barındıran şifreleme sistemi teknolojisi hangisidir?",
                    "Blok Zinciri",
                    new String[]{"GPRS (General Packet Radio Service) Hizmeti", "Kızılötesi (Infrared) Bağlantı", "Elektronik Bankacılık", "Blok Zinciri"}),
            new Question("Hangisi mobil bankacılığın sunduğu imkanlardan biri değildir?",
                    "Kasa kiralamak",
                    new String[]{"Şube randevusu almak", "QR kod ile para çekmek ve yatırmak", "Kasa kiralamak", "Hiçbiri"}),
            new Question("2018 yılının sonu itibari ile dünya nüfusunun yaklaşık yüzde kaçı aktif internet kullanıcısıdır?",
                    "%50",
                    new String[]{"%50", "%60", "%70", "%80"}),
            new Question("Ödeme sistemleri, chatbot, yapay zekâ uygulamaları gibi dijital çözümleri kapsayan finans ve bankacılık teknolojisi hangisidir?",
                    "Fintech",
                    new String[]{"Edtech", "Madtech", "Regtech", "Fintech"}),
    };
}
