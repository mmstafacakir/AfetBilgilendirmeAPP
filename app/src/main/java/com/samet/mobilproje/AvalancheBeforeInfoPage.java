package com.samet.mobilproje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.samet.mobilproje.databinding.ActivityAvalancheBeforeInfoPageBinding;

public class AvalancheBeforeInfoPage extends AppCompatActivity {

    ActivityAvalancheBeforeInfoPageBinding binding;

    private String[] cigOnce = {"Çığ riskinin bulunduğu bölgelerde yaşayan kişiler için çığ öncesinde alınacak önlemler" +
            " hayati önem taşır. İşte çığ öncesinde yapılması gereken bazı hazırlıklar:", "Çığ Tehlikesi Haritalarını Kontrol" +
            " Edin: Bulunduğunuz bölgenin çığ riskini belirleyen haritaları kontrol edin. Yerel yetkililerin sağladığı çığ" +
            " tehlikesi haritalarını inceleyerek, riskli bölgeleri ve güvenli alanları belirleyin.", "Hava Durumunu ve Kar" +
            " Durumunu Takip Edin: Çığ tehlikesi bulunan bir bölgede yaşıyorsanız, düzenli olarak hava durumu raporlarını" +
            " takip edin. Özellikle kar yağışı miktarı ve kar tabakasının istikrarı hakkında bilgi sahibi olun.", "İyi" +
            " Donatılmış Bir Kurtarma Seti Edinin: Çığ öncesinde, çığ kurtarma ekipmanlarından oluşan bir set edinin. Bu set," +
            " çığ sondası, lavinya arama cihazı (LVS), kürek, sondaj testere gibi malzemeleri içermelidir. Bu malzemeler, bir" +
            " çığ durumunda kurtarma çalışmalarında size yardımcı olacaktır.","Güvenli Ekipman Kullanın: Çığ tehlikesi olan bölgelerde" +
            " faaliyet gösterirken güvenli ekipmanlar kullanmaya özen gösterin. Bu, çığ transceiver'ı, koruyucu başlık, çığ airbag'ı" +
            "ve güvenli bir kask gibi malzemeleri içerebilir.","Güncel Eğitim Alın: Çığ tehlikesi olan bölgelerde faaliyet gösterecekseniz," +
            " çığ eğitimi almanız önemlidir. Çığ eğitimi, doğru tepkileri ve kurtarma tekniklerini öğrenmenizi sağlar. Bu eğitimleri" +
            " yetkililer veya profesyonel dağ rehberleri aracılığıyla alabilirsiniz.","Seyahat Planını Paylaşın: Çığ tehlikesi olan" +
            " bir bölgede seyahat edecekseniz, seyahat planınızı güvendiğiniz bir kişi veya kuruluşla paylaşın. Bu, olası bir çığ" +
            " durumunda başkalarının sizi arama ve kurtarma çalışmalarına katılmasını sağlar.","Uyarı İşaretlerini Tanıyın: Çığ" +
            " tehlikesini gösteren uyarı işaretlerini tanımak önemlidir. Kırık kar tabakaları, karın çökmesi, çatlaklar, eğimli" +
            " alanlarda birikmiş kar ve son zamanlarda meydana gelen kar yağışı gibi işaretlere dikkat edin.","Çığ öncesinde bu" +
            " hazırlıkları yaparak, güvenliğinizi artırabilir ve çığ tehlikesine karşı daha dirençli olabilirsiniz. Ancak unutmayın," +
            " çığ riski olan bölgelerde dikkatli olmak ve profesyonel rehberlik almak önemlidir."};

    private int currentIndex = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAvalancheBeforeInfoPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.infoText.setText(cigOnce[0]);

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
        if (currentIndex < cigOnce.length) {
            String currentString = cigOnce[currentIndex];
            binding.infoText.setText(currentString);
            currentIndex++;
        } else {
            binding.infoText.setText("Dizi Sonuna Ulaşıldı");
        }
    }

    private void geri() {
        if (currentIndex > 0) {
            currentIndex--;
            String currentString = cigOnce[currentIndex];
            binding.infoText.setText(currentString);
        } else {
            binding.infoText.setText("Dizi Başına Ulaşıldı");
        }
    }
}