package com.samet.mobilproje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.samet.mobilproje.databinding.ActivityFiresInfoPageBinding;

public class FiresInfoPage extends AppCompatActivity {

    ActivityFiresInfoPageBinding binding;
    private int currentIndex = 1;

    private String[] yanginAn = {"Yangın anında doğru tepkiler vermek, can güvenliğinizi korumanızı sağlamak için büyük önem taşır." +
            " İşte yangın anında yapmanız gerekenler:", "Hemen İhbar Edin: Yangını fark ettiğiniz anda hemen yangın alarmını çalıp" +
            " itfaiye ekiplerine haber verin. Acil durum numaralarını arayarak yangının yerini, büyüklüğünü ve varsa mahsur kalan" +
            " insanları bildirin. Hızlıca müdahale etmek, yangının kontrol altına alınmasına yardımcı olur.", "Güvenli Bir Yere " +
            "Tahliye Olun: Yangın sırasında hızla ve sakin bir şekilde bina veya alandan çıkın. Tahliye yollarını kullanarak güvenli " +
            "bir bölgeye doğru ilerleyin. Asansörleri kullanmayın, yangın merdivenlerini tercih edin. Kapıları ve pencereleri kapatarak," +
            " yangının yayılma hızını kontrol altına alın.", "Kapalı Kapıları Kontrol Edin: Eğer yangın sırasında kapıları açmak" +
            " zorunda kalıyorsanız, kapının üzerine elinizi koyarak kapının sıcaklığını kontrol edin. Sıcak bir kapı durumunda" +
            " diğer bir kaçış yolu arayın veya kapıyı açmadan önce yanıcı gazları ve dumanı engellemek için bir bez veya giysiyle" +
            " kapıyı kapatın.","Duman Altında Kalırsan Yerde Sürün: Dumanın yoğun olduğu alanlarda nefes almak için sürünerek" +
            " ilerleyin. Dumanın yoğun olduğu yerlerde sürünmek, daha temiz hava seviyesine yakın olmanızı sağlar. Mümkün olduğunca" +
            " az duman solumak, zehirlenme riskinizi azaltır.","Yangın Söndürücüleri Kullanın (Eğitimli İseniz): Eğer yangın söndürme" +
            " eğitimi almışsanız ve yangın küçük ölçekli ise uygun yangın söndürücüyü kullanarak yangını kontrol altına almaya çalışın." +
            " Yangın söndürücü kullanırken, rüzgar yönünde durarak ve söndürme talimatlarına uyarak hareket edin. Ancak, kendinizi" +
            " riske atmadan yangını söndürmeye çalışın.","Mahsur Kaldıysanız İhbar Verin: Eğer yangın sırasında mahsur kalırsanız," +
            " pencereye çıkarak dikkat çekmeye çalışın. Beyaz bir bez, giysi veya ışık kaynağı gibi göze çarpan şeyler kullanarak" +
            " yardım çağırın. Siren veya düdük gibi ses çıkaran araçları kullanarak kendinizi duyurmaya çalışın.","Yangın anında" +
            " yapılması gerekenler büyük önem taşır. İtfaiye ekiplerinin gelene kadar sakin olmaya çalışın ve gerekli tedbirleri" +
            " alarak kendinizi ve diğerlerini güvende tutmaya çalışın. Unutmayın, her zaman can güvenliği öncelikli olmalı ve risk" +
            " altına girmemek adına profesyonel yardım almanız gerekebilir."};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFiresInfoPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.infoText.setText(yanginAn[0]);
        binding.btnMainPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainPage();
            }
        });

        binding.InfoPageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTransitionPage();
            }
        });

        binding.InfoPageSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettingsPage();
            }
        });

        binding.infoNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ileri();
            }
        });

        binding.infoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                geri();
            }
        });

    }

    public void openTransitionPage(){
        Intent intent = new Intent(this, transitionPage.class);
        startActivity(intent);
    }
    public void openMainPage(){
        Intent intent = new Intent(this, MainPage.class);
        startActivity(intent);
    }

    public void openSettingsPage(){
        Intent intent = new Intent(this, settingsPage.class);
        startActivity(intent);
    }

    private void ileri() {
        if (currentIndex < yanginAn.length) {
            String currentString = yanginAn[currentIndex];
            binding.infoText.setText(currentString);
            currentIndex++;
        } else {
            binding.infoText.setText("Dizi Sonuna Ulaşıldı");
        }
    }

    private void geri() {
        if (currentIndex > 0) {
            currentIndex--;
            String currentString = yanginAn[currentIndex];
            binding.infoText.setText(currentString);
        } else {
            binding.infoText.setText("Dizi Başına Ulaşıldı");
        }
    }
}