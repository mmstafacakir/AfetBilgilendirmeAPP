package com.samet.mobilproje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.samet.mobilproje.databinding.ActivityTsunamiBeforaInfopageBinding;

public class TsunamiBeforaInfoPage extends AppCompatActivity {

    ActivityTsunamiBeforaInfopageBinding binding;
    private int currentIndex = 1;

    private String[] tsunamiOnce = {"Tsunami, ciddi bir doğal afet olduğundan, önceden doğru önlemler almak hayati önem taşır. İşte" +
            " tsunami öncesinde yapmanız gereken bazı hazırlıklar:", "Tsunami Tehlikesini Bilin: Yaşadığınız bölgede tsunami tehlikesi" +
            " varsa, bu tehlikeyi ve risk faktörlerini iyi anlayın. Resmi yetkililerden, yerel hükümetten veya tsunami uyarı sistemlerinden" +
            " güncel bilgileri takip edin. Tsunami tehlikesi ve tahmin edilen dalgaların yüksekliği hakkında bilgi sahibi olun.",
            "Tahliye Yollarını Belirleyin: Yaşadığınız bölgede tsunami durumunda tahliye yollarını belirleyin. Tsunami sırasında güvenli" +
                    " bir alana ulaşmanızı sağlayacak en kısa ve güvenli yolları tespit edin. Tahliye planınızı aileniz veya ev " +
                    "arkadaşlarınızla paylaşın.", "Tsunami Çantası Hazırlayın: Tsunami durumunda hızlı bir şekilde hareket etmeniz" +
            " gerekebilir. Acil durum çantası hazırlayarak içerisine temel ihtiyaç malzemeleri, su, yiyecek, ilaçlar, ilk yardım " +
            "malzemeleri, dürbün ve kişisel belgeler gibi önemli eşyaları koyun. Bu çantayı her zaman kolayca erişebileceğiniz bir" +
            " yerde tutun.","Tsunami Uyarı Sistemlerini İzleyin: Tsunami uyarı sistemlerini takip edin ve anonslara dikkat edin. " +
            "Radyo, televizyon, internet veya cep telefonu uygulamaları gibi kaynakları kullanarak güncel bilgileri alın. Resmi yetkililerin" +
            " talimatlarını dikkate alın ve gerektiğinde derhal harekete geçin.","Deniz Kenarından Uzak Durun: Tsunami uyarısı " +
            "yapıldığında veya şiddetli bir deprem meydana geldiğinde deniz kenarından hemen uzaklaşın. Tsunami dalgaları genellikle" +
            " kıyıya doğru ilerlerken güçlenir. Düşük rakımlı veya sığ bölgelerden yüksek ve güvenli bir yere çıkın.","Toplanma Noktası" +
            " Belirleyin: Tsunami durumunda aileniz veya ev arkadaşlarınızla buluşmak için güvenli bir toplanma noktası belirleyin. " +
            "Herkesin nerede buluşacağını bilmesi, birbirinizi bulmanızı kolaylaştırır ve endişeleri azaltır.","Tsunami öncesinde bu " +
            "hazırlıkları yapmak, can güvenliğinizi artırabilir ve hızlı hareket etmenizi sağlayabilir. Tsunami durumunda da dikkatli" +
            " olmak, resmi yetkililerin talimatlarını izlemek ve güvende olmak için uygun önlemleri almak önemlidir."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTsunamiBeforaInfopageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.infoText.setText(tsunamiOnce[0]);

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
        Intent intent = new Intent(this, transitionBeforePage.class);
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
        if (currentIndex < tsunamiOnce.length) {
            String currentString = tsunamiOnce[currentIndex];
            binding.infoText.setText(currentString);
            currentIndex++;
        } else {
            binding.infoText.setText("Dizi Sonuna Ulaşıldı");
        }
    }

    private void geri() {
        if (currentIndex > 0) {
            currentIndex--;
            String currentString = tsunamiOnce[currentIndex];
            binding.infoText.setText(currentString);
        } else {
            binding.infoText.setText("Dizi Başına Ulaşıldı");
        }
    }
}