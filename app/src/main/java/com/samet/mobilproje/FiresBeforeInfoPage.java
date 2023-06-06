package com.samet.mobilproje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.samet.mobilproje.databinding.ActivityFloodBeforeInfoPageBinding;

public class FiresBeforeInfoPage extends AppCompatActivity {

    ActivityFloodBeforeInfoPageBinding binding;
    private int currentIndex = 1;

    private String[] yanginOnce = {"Yangın öncesinde doğru önlemler almak, can güvenliğinizi ve mal varlığınızı korumak için hayati önem" +
            " taşır. İşte yangın öncesinde yapmanız gereken bazı hazırlıklar:", "Yangın İçin Plan Yapın: Ev veya işyerinizde yangın" +
            " durumunda yapılması gereken adımları içeren bir yangın planı oluşturun. Bu plan, tahliye yollarını belirlemek, yangın" +
            " söndürme ekipmanını tanımak ve aile veya çalışma arkadaşlarınızla iletişimi içerebilir.", "Yangın İhbar Sistemini Kontrol" +
            " Edin: Ev veya işyerinizdeki yangın ihbar sistemlerini düzenli olarak kontrol edin. Yangın alarmı, duman dedektörü ve yangın" +
            " söndürme cihazları gibi önleyici ekipmanların çalışır durumda olduğundan emin olun.", "Yangın Söndürme Ekipmanlarını Kontrol" +
            " Edin: Ev veya işyerinizde yangın söndürme ekipmanlarını düzenli olarak kontrol edin. Yangın söndürücülerin tarihini kontrol" +
            " edin ve gerektiğinde yenileyin. Ayrıca, yangın battaniyeleri gibi diğer yangın söndürme araçlarını da hazır tutun.",
            "Elektrikli Cihazları Düzenli Kontrol Edin: Elektrikli cihazları düzenli olarak kontrol edin ve bakımlarını yapın. Kıvrık" +
                    " veya hasar görmüş kabloları değiştirin ve çoklu prizlerin üzerine aşırı yüklenmeyin. Elektrikli cihazları" +
                    " kullanırken dikkatli olun ve gereksiz yere açık bırakmaktan kaçının.","Yanıcı Maddeleri Doğru Şekilde Saklayın:" +
            " Ev veya işyerinde yanıcı maddeleri doğru şekilde saklayın. Yangına neden olabilecek maddeleri, ateşten uzak, serin ve" +
            " kuru bir yerde tutun. Ayrıca, yanıcı maddelerin etrafında yangın söndürücülerin bulunmasını sağlayın.","Yangın Tahliye" +
            " Yollarını Temiz Tutun: Ev veya işyerindeki yangın tahliye yollarını temiz ve engelsiz tutun. Mobilyaları, eşyaları" +
            " veya diğer nesneleri tahliye yollarına engel olacak şekilde yerleştirmeyin. Acil durumda hızlı ve güvenli bir şekilde" +
            " binayı terk etmek için serbest bir geçiş sağlayın.","Yangınla İlgili Eğitim Alın: Yangın durumunda yapılması gerekenleri" +
            " öğrenmek için yangınla ilgili eğitimler alın. İtfaiye departmanı veya diğer yetkili kuruluşlar tarafından sunulan yangın" +
            " güvenliği eğitimlerine katılın. Bu eğitimler, yangına nasıl müdahale edileceğini ve nasıl tahliye edileceğinizi öğretir."
            ,"Yangın öncesinde bu hazırlıkları yaparak, yangın riskini azaltabilir ve güvenliğinizi artırabilirsiniz. Ancak unutmayın," +
            " yangın durumunda acil durum numaralarını aramak ve profesyonel yardım almak her zaman en doğru yaklaşımdır."};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFloodBeforeInfoPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.infoText.setText(yanginOnce[0]);
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
        if (currentIndex < yanginOnce.length) {
            String currentString = yanginOnce[currentIndex];
            binding.infoText.setText(currentString);
            currentIndex++;
        } else {
            binding.infoText.setText("Dizi Sonuna Ulaşıldı");
        }
    }

    private void geri() {
        if (currentIndex > 0) {
            currentIndex--;
            String currentString = yanginOnce[currentIndex];
            binding.infoText.setText(currentString);
        } else {
            binding.infoText.setText("Dizi Başına Ulaşıldı");
        }
    }
}