package com.samet.mobilproje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.samet.mobilproje.databinding.ActivityEqbeforeInfoPageBinding;

public class EQBeforeInfoPage extends AppCompatActivity {

    ActivityEqbeforeInfoPageBinding binding;
    private int currentIndex = 1;

    private String[] depremOnce = {"Deprem öncesinde hazırlık yapmak, afetin etkilerini en aza indirmek ve hayat kurtarmak" +
            " açısından son derece önemlidir. İşte deprem öncesinde yapılması gereken bazı hazırlıklar:",
            "Acil Durum Planı: Ailenizle birlikte acil durum planı oluşturun. Bu plan, aile bireylerinin ne yapması gerektiğini" +
                    " ve nerede buluşacaklarını belirlemelidir. Acil durumda iletişimi sağlamak için önemli telefon numaralarını" +
                    " ve adresleri not edin.", "Acil Durum Çantası: Her evde bir acil durum çantası bulundurun. Bu çanta " +
            "içerisinde birkaç gün yetecek kadar temel ihtiyaç malzemeleri, ilaçlar, su, kuru gıda, el feneri, pil, radyo, " +
            "battaniye gibi acil durum ekipmanları bulunmalıdır.", "Ev Güvenliği: Evde olası bir depremde zarar görmeyi " +
            "önlemek için önlemler alın. Sıvılar ve kırılabilir eşyalar için güvenli depolama yöntemleri kullanın. Ağır " +
            "mobilyaları, dolapları ve diğer eşyaları duvarlara sabitleyin. Elektrik ve gaz bağlantılarını düzgün bir " +
            "şekilde kontrol edin.","Acil Çıkış Yolları: Evde ve iş yerinde acil çıkış yollarını belirleyin. Deprem " +
            "sırasında güvenli bir şekilde dışarıya çıkmanızı sağlayacak açık ve erişilebilir çıkış yollarını belirleyin. " +
            "Gerekirse merdivenlerde veya koridorlarda ek güvenlik önlemleri alın.","İtfaiye ve Acil Durum Hizmetleri: " +
            "Mahallenizdeki itfaiye, sağlık ve diğer acil durum hizmetlerinin iletişim bilgilerini ve acil numaraları not edin." +
            " Aynı zamanda, yakınınızdaki acil durum merkezlerini ve toplanma noktalarını önceden belirleyin.",
            "Deprem Sigortası: Ev ve mülkleriniz için uygun bir deprem sigortası yaptırın. Bu sigorta, olası " +
                    "hasarları karşılamak ve yeniden inşa sürecinde maddi olarak destek sağlamak için önemlidir.",
            "Bilinçlenme ve Eğitim: Deprem hakkında bilgi edinin ve ailenizi, çocuklarınızı ve iş arkadaşlarınızı deprem " +
                    "konusunda eğitin. Deprem anında nasıl davranılması gerektiğini, güvenli yerlerin neler olduğunu ve " +
                    "panik durumlarında nasıl tepki verilmesi gerektiğini öğrenin.","Deprem öncesinde yapılan bu hazırlıklar," +
            " depremin etkilerini en aza indirgemeye ve can güvenliğini sağlamaya yardımcı olacaktır. Düzenli olarak bu " +
            "hazırlıkları gözden geçirin ve gerekli güncellemeleri yapın."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEqbeforeInfoPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.infoText.setText(depremOnce[0]);

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
        if (currentIndex < depremOnce.length) {
            String currentString = depremOnce[currentIndex];
            binding.infoText.setText(currentString);
            currentIndex++;
        } else {
            binding.infoText.setText("Dizi Sonuna Ulaşıldı");
        }
    }

    private void geri() {
        if (currentIndex > 0) {
            currentIndex--;
            String currentString = depremOnce[currentIndex];
            binding.infoText.setText(currentString);
        } else {
            binding.infoText.setText("Dizi Başına Ulaşıldı");
        }
    }
}