package com.samet.mobilproje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.samet.mobilproje.databinding.ActivityFloodInfoPageBinding;

public class FloodInfoPage extends AppCompatActivity {

    ActivityFloodInfoPageBinding binding;
    private int currentIndex = 1;

    private String[] selAn = {"Sel anında doğru ve hızlı tepki vermek hayati önem taşır. Sel sularının hızla yükselmesi ve tehlikeli" +
            " bir şekilde akması durumunda aşağıdaki adımları izleyin:", "Hemen güvenli bir yere geçin. Sel sularından etkilenen" +
            " alanlardaysanız, yüksek yerlere veya binalara çıkın. Mümkünse, en üst katlara ulaşmaya çalışın.", "Elektrik ve gaz" +
            " bağlantılarını kapatın. Sel sularının elektrik ve gaz hatlarına zarar verme olasılığı vardır. Güvenliğiniz için elektrik" +
            " ve gaz bağlantılarını kapatın.", "İlerleyebileceğiniz güvenli bir yola yönelin. Eğer sel sularından kaçmak için hareket" +
            " etmeniz gerekiyorsa, güvenli bir yol seçin. Dikkatlice ilerleyin ve derin su birikintilerinden kaçının. Akıntılı sulara" +
            " girmemeye özen gösterin.","Yetkililerin talimatlarını takip edin. Sel sırasında yerel yetkililer tarafından verilen" +
            " talimatları takip edin. Radyo veya diğer haber kaynaklarından güncel bilgilere ulaşmaya çalışın. Kurtarma ekiplerinin" +
            " size yönlendirmelerine uyun.","Yardım talebinde bulunun. Sel suları altında mahsur kalırsanız, yardım talebinde bulunun." +
            " Sesinizi duyurabileceğiniz yüksek bir noktaya çıkın veya bir çağrı cihazı kullanın. Yardımın gelmesini bekleyin ve" +
            " umutsuzluğa kapılmayın.","Eşyalarınızın peşinden gitmeyin. Sel sularının gücüne kapılarak eşyalarınızın peşinden gitmeye" +
            " çalışmayın. Hayatınız her şeyden daha değerlidir. Can güvenliğinizi ön planda tutun.","Sel anında bu önlemleri alarak," +
            " kendinizi ve sevdiklerinizi koruma altına alabilirsiniz. Sel riski olan bölgelerde yaşayan kişilerin sel uyarılarına dikkat" +
            " etmeleri ve sel sularının hızla yükselmesi durumunda güvenli alanlara geçmeleri önemlidir. Unutmayın, can güvenliği her zaman" +
            " önceliklidir."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFloodInfoPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.infoText.setText(selAn[0]);

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
        if (currentIndex < selAn.length) {
            String currentString = selAn[currentIndex];
            binding.infoText.setText(currentString);
            currentIndex++;
        } else {
            binding.infoText.setText("Dizi Sonuna Ulaşıldı");
        }
    }

    private void geri() {
        if (currentIndex > 0) {
            currentIndex--;
            String currentString = selAn[currentIndex];
            binding.infoText.setText(currentString);
        } else {
            binding.infoText.setText("Dizi Başına Ulaşıldı");
        }
    }
}