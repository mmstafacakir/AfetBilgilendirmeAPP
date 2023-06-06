package com.samet.mobilproje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.samet.mobilproje.databinding.ActivityStormsBeforeInfoPageBinding;

public class StormsBeforeInfoPage extends AppCompatActivity {

    ActivityStormsBeforeInfoPageBinding binding;

    private int currentIndex = 1;
    private String[] firtinaOnce = {"Fırtına öncesinde alınacak önlemler, güvenliğinizi sağlamak ve maddi hasarı en aza indirmek" +
            " için önemlidir. İşte fırtına öncesinde yapılması gereken bazı hazırlıklar:", "Hava Tahminlerini Takip Edin: Fırtına" +
            " riski olduğunda hava tahminlerini düzenli olarak takip edin. Güncel hava durumu bilgilerini ve fırtına uyarılarını" +
            " öğrenmek için yerel haber kaynaklarını veya hava durumu uygulamalarını kullanın.", "Evinizi ve Bahçenizi Hazırlayın:" +
            " Evinizin çevresindeki gevşek nesneleri, saksıları ve diğer eşyaları güvence altına alın. Fırtınanın etkilerini azaltmak" +
            " için çevrenizdeki ağaçların dallarını budayın ve gevşek eşyaları içeriye alın.", "Acil Durum Çantası: Her evde bir acil" +
            "durum çantası bulundurun. Bu çanta içerisinde temel ihtiyaç malzemeleri, el feneri, pil, radyo, su, kuru gıda ve ilaçlar" +
            " gibi acil durum ekipmanları bulunmalıdır.","Pencereleri ve Kapıları Kontrol Edin: Pencereleri ve kapıları güçlendirin." +
            " Perdeleri kapatın ve camlara koruyucu kaplamalar veya tahtalar yerleştirin. Bu önlemler, fırtınanın şiddetini azaltmak" +
            " ve camların kırılmasını önlemek için önemlidir.","Elektrik ve Gaz Bağlantılarını Kapatın: Fırtına riski yüksekse, elektrik" +
            " ve gaz bağlantılarını kapatın. Bu, olası elektrik çarpmalarını ve gaz sızıntılarını önlemek için önemlidir.","Seyahat" +
            " Planlarını Gözden Geçirin: Fırtına beklendiğinde planladığınız seyahatleri gözden geçirin. Gerekirse seyahatleri erteleyin" +
            " veya iptal edin. Yolda kalmamak ve güvende olmak için güncel trafik durumu hakkında bilgi edinin."," Güvenli Bir İç Mekâna" +
            " Geçin: Fırtına başlamadan önce güvenli bir iç mekâna geçin. Mümkünse, binanın en güvenli ve dayanıklı bölgesine geçin." +
            " Pencerelerden ve cam eşyalardan uzak durun.","Fırtına öncesinde bu hazırlıkları yaparak, kendinizi ve evinizi güvende" +
            " tutabilirsiniz. Düzenli olarak fırtına güvenliği hakkında bilgi edinin ve yetkililerin talimatlarını takip edin."};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStormsBeforeInfoPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.infoText.setText(firtinaOnce[0]);

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
        if (currentIndex < firtinaOnce.length) {
            String currentString = firtinaOnce[currentIndex];
            binding.infoText.setText(currentString);
            currentIndex++;
        } else {
            binding.infoText.setText("Dizi Sonuna Ulaşıldı");
        }
    }

    private void geri() {
        if (currentIndex > 0) {
            currentIndex--;
            String currentString = firtinaOnce[currentIndex];
            binding.infoText.setText(currentString);
        } else {
            binding.infoText.setText("Dizi Başına Ulaşıldı");
        }
    }
}