package com.samet.mobilproje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.samet.mobilproje.databinding.ActivityFloodBeforeInfoPageBinding;

public class FloodBeforeInfoPage extends AppCompatActivity {

    private ActivityFloodBeforeInfoPageBinding binding;
    private int currentIndex = 1;

    private String[] selOnce = {"Sel felaketleri, özellikle yağışlı mevsimlerde büyük zararlara neden olabilir. Bu nedenle," +
            " sel öncesinde alınacak önlemler hayati öneme sahiptir. İşte sel öncesinde yapılması gereken bazı hazırlıklar:"
            , "Sel Tehlikesi Haritası: Bulunduğunuz bölgenin sel riskini belirleyen haritaları kontrol edin. Eğer sel riski" +
            " yüksek bir bölgede yaşıyorsanız, sel sığınma alanları ve tahliye yollarını önceden belirleyin.", "Acil Durum " +
            "Planı: Ailenizle birlikte acil durum planı oluşturun. Bu plan, sel tehlikesi durumunda ne yapmanız gerektiğini" +
            " belirlemelidir. Nerede buluşacağınızı ve nasıl iletişim kuracağınızı belirleyin.", "Evinizi Hazırlayın: Evde " +
            "sel riskini azaltmak için önlemler alın. Elektrik tesisatını kontrol edin ve olası su sızıntılarını önleyin. " +
            "Kanalizasyon ve drenaj sistemlerini temiz ve işlevsel tutun. Değerli eşyalarınızı yükseltilmiş bir yere taşıyın" +
            " veya su geçirmez torbalarda saklayın.","Acil Durum Çantası: Her evde bir acil durum çantası bulundurun. Bu " +
            "çanta içerisinde birkaç gün yetecek kadar temel ihtiyaç malzemeleri, ilaçlar, su, kuru gıda, el feneri, pil, " +
            "radyo, battaniye gibi acil durum ekipmanları bulunmalıdır.","Haberleri Takip Edin: Meteorolojik tahminleri ve " +
            "sel uyarılarını düzenli olarak takip edin. Hükümetin ve yerel yetkililerin verdiği sel uyarılarını dikkate alın" +
            " ve talimatlara uyun.","Araçlarınızı Güvende Tutun: Sel riski olan bir bölgede yaşıyorsanız, araçlarınızı yüksek" +
            " yerlere veya güvenli otoparklara park edin. Mümkünse, aracınızın yakıt deposunu doldurun.","Komşularınızı " +
            "Bilgilendirin: Sel tehdidi hakkında komşularınızı bilgilendirin ve birlikte hareket etme planları yapın. " +
            "Yardımlaşma ve dayanışma önemli bir faktördür.","Sel öncesinde bu hazırlıkları yaparak, sel felaketinin " +
            "etkilerini en aza indirebilir ve güvenliğinizi sağlayabilirsiniz. Düzenli olarak sel riskini değerlendirin" +
            " ve güncellemeler yapın. Aynı zamanda, sel sigortası yaptırmak da önemli bir adımdır."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFloodBeforeInfoPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.infoText.setText(selOnce[0]);

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
        if (currentIndex < selOnce.length) {
            String currentString = selOnce[currentIndex];
            binding.infoText.setText(currentString);
            currentIndex++;
        } else {
            binding.infoText.setText("Dizi Sonuna Ulaşıldı");
        }
    }

    private void geri() {
        if (currentIndex > 0) {
            currentIndex--;
            String currentString = selOnce[currentIndex];
            binding.infoText.setText(currentString);
        } else {
            binding.infoText.setText("Dizi Başına Ulaşıldı");
        }
    }
}