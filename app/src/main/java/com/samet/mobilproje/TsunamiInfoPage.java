package com.samet.mobilproje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.samet.mobilproje.databinding.ActivityTsunamiInfoPageBinding;

public class TsunamiInfoPage extends AppCompatActivity {

    ActivityTsunamiInfoPageBinding binding;
    private int currentIndex = 1;

    private String[] tsunamiAn = {"Tsunami anında doğru hareket etmek, can güvenliğinizi korumak için kritik önem taşır." +
            " İşte tsunami anında yapmanız gerekenler:", "Hemen Güvenli Bir Yere Sığının: Tsunami tehlikesi olduğunda," +
            " hemen yüksek ve güvenli bir noktaya sığının. Bina içindeyseniz, mümkünse üst katlara çıkın. Tsunami dalgaları" +
            " genellikle kıyı bölgelerini vururken, yüksek rakımlı bölgelerde güçsüzleşirler. Deniz kenarından uzaklaşın ve" +
            " mümkünse dağınık yerleşim alanlarına yönelin.", "Güncel Bilgilere Ulaşın: Tsunami uyarısı olduğunda veya deprem" +
            " meydana geldiğinde, radyo, televizyon veya cep telefonu uygulamaları gibi güvenilir kaynakları kullanarak güncel" +
            " bilgilere ulaşmaya çalışın. Resmi yetkililerin talimatlarını dinleyin ve verilen tahliye emirlerine uyun.", "Tsunami" +
            " Dalgalarından Kaçının: Tsunami dalgaları çok güçlü olabilir ve büyük hasara neden olabilir. Dalgaların gelmesi" +
            " durumunda, açık alanlarda bulunuyorsanız yüksek ve sağlam bir yapıya veya tepelere doğru hareket edin. Tsunami" +
            " dalgalarının yayılma hızı çok yüksek olduğundan, kaçış rotanızı dikkatli bir şekilde seçin ve hızlı hareket edin." +
            "","Güvende Kalın: Tsunami dalgaları sırasında sakin olun ve paniklemeyin. Güçlü akıntılar ve su baskını riski olabilir," +
            " bu yüzden dikkatli olun. Yakınındaki su birikintilerine veya su birikintilerine yaklaşmayın. Elektrik hatlarından," +
            " yıkılmış binalardan veya diğer tehlikeli nesnelerden uzak durun.","Yardım Çağırın: Mahsur kalan veya yardıma ihtiyacı" +
            " olan insanları gördüğünüzde, derhal yardım çağırın. İtfaiye, polis veya diğer kurtarma ekiplerine bilgi verin ve" +
            " mümkünse bu kişileri güvenli bir yere taşımak için yardımcı olun.","Tsunami anında, hızlı ve doğru tepkiler vermek" +
            " hayati önem taşır. Kendinizi ve sevdiklerinizi güvende tutmak için yüksek yerlere sığınmak, güncel bilgilere erişmek" +
            " ve resmi talimatlara uymak çok önemlidir. Tsunami tehlikesi geçene kadar dikkatli olun ve güvenliği ön planda tutun."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTsunamiInfoPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.infoText.setText(tsunamiAn[0]);
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
        if (currentIndex < tsunamiAn.length) {
            String currentString = tsunamiAn[currentIndex];
            binding.infoText.setText(currentString);
            currentIndex++;
        } else {
            binding.infoText.setText("Dizi Sonuna Ulaşıldı");
        }
    }

    private void geri() {
        if (currentIndex > 0) {
            currentIndex--;
            String currentString = tsunamiAn[currentIndex];
            binding.infoText.setText(currentString);
        } else {
            binding.infoText.setText("Dizi Başına Ulaşıldı");
        }
    }
}