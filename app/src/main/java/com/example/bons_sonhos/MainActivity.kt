package com.example.bons_sonhos

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


//cores adicionais

val azul_confort = Color(0xFF7BC4C4)
val rose_confort = Color(0xFFFEDCC0)
val azul_escuro = Color(0xFF37474F)
val roxo_confort = Color(0xffA8639F)
val marsala_confort = Color(0xffF457A3)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Inicio() // Chama diretamente a tela inicial
        }
    }
}

@Composable
fun Inicio() {
    val navController = rememberNavController() // Lembra o controlador de navegação
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Define as rotas para navegação
                NavHost(navController = navController, startDestination = "splash") {
                    composable("splash") { ConteudoSplash(navController, innerPadding) }
                    composable("storyapp") { StoryApp(navController, innerPadding) }
                    composable("musicas") { Musicas_Opcoes(navController, innerPadding) }
                    composable("musica1") { First_Music(navController, innerPadding) }
                    composable("musica2") { Second_Music(navController, innerPadding) }
                    composable("musica3") { Third_Music(navController, innerPadding) }
                }
            }
        }
    )
}

@Composable
fun ConteudoSplash(
    navController: NavController? = null,
    innerPadding: PaddingValues = PaddingValues()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(R.drawable.tela_nuvens),
                contentScale = ContentScale.Crop
            )
            .fillMaxSize(),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_aplicativo),  // Logo do aplicativo
            contentDescription = "Logo Aplicativo",
            modifier = Modifier
                .size(width = 200.dp, height = 200.dp)
                .padding(bottom = 16.dp)
        )
        Text(
            text = "TinyDreamer",
            fontSize = 40.sp,
            fontWeight = FontWeight.SemiBold,
            color = azul_confort,
            fontFamily = FontFamily.Cursive
        )
        Spacer(modifier = Modifier.padding(top = 70.dp))

        Button(
            onClick = {
                if (navController != null) {
                    navController.navigate("storyapp")
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = rose_confort,
                contentColor = azul_confort
            ),
            modifier = Modifier.size(width = 230.dp, height = 38.dp)
        ) {
            Text(
                "INICIAR",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily.SansSerif
            )
        }
    }
}

@Composable
fun StoryApp(
    navController: NavController? = null,
    innerPadding: PaddingValues = PaddingValues()
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(R.drawable.tela_nuvens),
                contentScale = ContentScale.Crop
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 34.dp) // Margem lateral para alinhar à esquerda
        ) {
            Spacer(modifier = Modifier.height(95.dp)) // Ajuste a altura para descer a imagem

            // Row para organizar imagem e texto lado a lado
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically // Alinha o texto com a imagem
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_aplicativo),
                    contentDescription = "Logo Aplicativo",
                    modifier = Modifier.size(width = 80.dp, height = 80.dp)
                )

                Spacer(modifier = Modifier.width(16.dp)) // Espaço entre a imagem e o texto

                Text(
                    text = "TinyDreamer",
                    style = TextStyle(
                        fontSize = 30.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = azul_confort,
                        fontFamily = FontFamily.Cursive
                    )
                )
            }
        }

        // Coluna centralizada
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.padding(top = 60.dp))

            // Coloca o Card dentro de um Box com a borda
            Box(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .border(
                        BorderStroke(2.dp, color = roxo_confort),
                        shape = RoundedCornerShape(16.dp)
                    ) // Borda com cantos arredondados
            ) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp), // Borda arredondada do card
                    colors = androidx.compose.material3.CardDefaults.cardColors(
                        containerColor = rose_confort // Cor de fundo do card
                    ),
                    elevation = androidx.compose.material3.CardDefaults.cardElevation(
                        defaultElevation = 4.dp
                    )
                ) {
                    Text(
                        text = "Aqui, tudo foi pensado para trazer tranquilidade e ajudar o seu bebê a ter noites de sono calmas e aconchegantes. " +
                                "Com sons suaves como o sopro do vento, a chuva que canta, e até o coração de um ursinho, criamos um ambiente perfeito para o descanso do seu pequeno sonhador.\n\n" +
                                "Toque em Avançar e comece essa jornada de paz e carinho.",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(16.dp), // Padding interno no texto
                        color = azul_escuro,
                        fontFamily = FontFamily.SansSerif
                    )
                }
            }



            Spacer(modifier = Modifier.height(24.dp)) // Espaço entre o card e o botão

            Button(
                onClick = {
                    if (navController != null) {
                        navController.navigate("musicas")
                    }
                },
                modifier = Modifier.padding(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = rose_confort,
                    contentColor = azul_confort
                )
            ) {
                Text(
                    "AVANÇAR",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily.SansSerif
                )
            }
        }
    }
}


@Composable
fun Musicas_Opcoes(
    navController: NavController? = null,
    innerPadding: PaddingValues = PaddingValues()
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(R.drawable.tela_nuvens),
                contentScale = ContentScale.Crop
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 34.dp)
        ) {
            Spacer(modifier = Modifier.height(95.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_aplicativo),
                    contentDescription = "Logo Aplicativo",
                    modifier = Modifier.size(width = 80.dp, height = 80.dp)
                )

                Spacer(modifier = Modifier.width(16.dp))

                Text(
                    text = "TinyDreamer",
                    style = TextStyle(
                        fontSize = 30.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = azul_confort,
                        fontFamily = FontFamily.Cursive
                    )
                )
            }
        }

        // Card centralizado com borda preta arredondada
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.8f) // Largura do Box (80% da tela)
                    .padding(16.dp) // Espaço em volta do Box
                    .border(
                        BorderStroke(2.dp, color = roxo_confort),
                        shape = RoundedCornerShape(16.dp)
                    ) // Borda preta com cantos arredondados
            ) {
                // Card para opções de músicas
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(8.dp), // Sombra do card
                    shape = RoundedCornerShape(16.dp), // Bordas arredondadas do card
                    colors = CardDefaults.cardColors(
                        containerColor = rose_confort // Cor de fundo do card
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp), // Espaçamento interno do Card
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        // Botão Música 1
                        Button(
                            onClick = {
                                if (navController != null) {
                                    navController.navigate("musica1")
                                }
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = roxo_confort,
                                contentColor = azul_confort
                            ),
                            modifier = Modifier
                                .fillMaxWidth() // Botão ocupa a largura total do Card
                                .padding(vertical = 8.dp)
                        ) {
                            Text(
                                text = "Chuvinha de Ninar",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = FontFamily.SansSerif
                            )
                        }

                        // Botão Música 2
                        Button(
                            onClick = {
                                if (navController != null) {
                                    navController.navigate("musica2")
                                }
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = roxo_confort,
                                contentColor = azul_confort
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp)
                        ) {
                            Text(
                                text = "Coração Acalmante",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = FontFamily.SansSerif
                            )
                        }

                        // Botão Música 3
                        Button(
                            onClick = {  if (navController != null) {
                                navController.navigate("musica3")
                            } },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = roxo_confort,
                                contentColor = azul_confort
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp)
                        ) {
                            Text(
                                text = "Nuvem de Paz",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = FontFamily.SansSerif
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun First_Music(
    navController: NavController? = null,
    innerPadding: PaddingValues = PaddingValues()
) {
    val context = LocalContext.current
    val mediaPlayer = remember {
        MediaPlayer.create(
            context,
            R.raw.som_chuva
        )
    } // Substitua 'som_chuva' pelo nome do arquivo
    var isPlaying by remember { mutableStateOf(false) }

    // Liberar recursos do MediaPlayer ao final
    DisposableEffect(Unit) {
        onDispose {
            mediaPlayer.release()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(R.drawable.tela_nuvens),
                contentScale = ContentScale.Crop
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 34.dp) // Margem lateral para alinhar à esquerda
        ) {
            Spacer(modifier = Modifier.height(95.dp)) // Ajuste a altura para descer a imagem

            // Row para organizar imagem e texto lado a lado
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically // Alinha o texto com a imagem
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_aplicativo),
                    contentDescription = "Logo Aplicativo",
                    modifier = Modifier.size(width = 80.dp, height = 80.dp)
                )

                Spacer(modifier = Modifier.width(16.dp)) // Espaço entre a imagem e o texto

                Text(
                    text = "TinyDreamer",
                    style = TextStyle(
                        fontSize = 30.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = azul_confort,
                        fontFamily = FontFamily.Cursive
                    )
                )
            }
        }

        // Coluna centralizada
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.padding(top = 60.dp))

            // Card ajustado com largura aumentada
            Card(
                modifier = Modifier
                    .fillMaxWidth(0.9f) // Aumenta a largura para 90% da tela
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 16.dp)
                    .shadow(4.dp, shape = RoundedCornerShape(16.dp)),
                shape = RoundedCornerShape(16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .background(rose_confort) // Cor de fundo do Card
                        .fillMaxWidth() // Preenche o tamanho do Card
                        .padding(16.dp) // Padding interno do Card
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "🌧️ Som de Chuva para Acalmar 🌧️",
                            style = TextStyle(
                                fontSize = 21.sp,
                                fontWeight = FontWeight.Bold,
                                color = marsala_confort,
                                fontFamily = FontFamily.Cursive,
                                textAlign = TextAlign.Center
                            )
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Deixe o som suave da chuva ajudar seu bebê a relaxar e adormecer com tranquilidade.",
                            style = TextStyle(
                                fontSize = 16.sp,
                                color = Color.Black,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Center
                            )
                        )
                    }
                }
            }

            // Player de música dentro do Box
            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .border(
                        BorderStroke(2.dp, color = roxo_confort),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .clip(RoundedCornerShape(16.dp))
                    .background(color = rose_confort)
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = if (isPlaying) "🎵 Reproduzindo Som 🎵" else "⏸️ Som Pausado ⏸️",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = azul_confort,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Botão Tocar/Pausar
                    Button(
                        onClick = {
                            if (isPlaying) {
                                mediaPlayer.pause()
                            } else {
                                mediaPlayer.start()
                            }
                            isPlaying = !isPlaying
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (isPlaying) Color(0xFFEF5350) else Color(0xFF66BB6A),
                            contentColor = Color.White
                        ),
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(50.dp),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = if (isPlaying) "⏸️ Pausar" else "▶️ Tocar",
                            style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Medium)
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Botão Reiniciar
                    Button(
                        onClick = {
                            mediaPlayer.seekTo(0)
                            mediaPlayer.start()
                            isPlaying = true
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF42A5F5),
                            contentColor = Color.White
                        ),
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(50.dp),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = "🔁 Reiniciar Som",
                            style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Medium)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp)) // Espaço entre o player e outros componentes
        }
    }
}


@Composable
fun Second_Music(
    navController: NavController? = null,
    innerPadding: PaddingValues = PaddingValues()
) {
    val context = LocalContext.current
    val mediaPlayer = remember {
        MediaPlayer.create(
            context,
            R.raw.somcoracao_1
        ) // Substitua 'som_chuva' pelo nome do arquivo
    }
    var isPlaying by remember { mutableStateOf(false) }

    // Liberar recursos do MediaPlayer ao final
    DisposableEffect(Unit) {
        onDispose {
            mediaPlayer.release()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(R.drawable.tela_nuvens),
                contentScale = ContentScale.Crop
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 34.dp) // Margem lateral para alinhar à esquerda
        ) {
            Spacer(modifier = Modifier.height(95.dp)) // Ajuste a altura para descer a imagem

            // Row para organizar imagem e texto lado a lado
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically // Alinha o texto com a imagem
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_aplicativo),
                    contentDescription = "Logo Aplicativo",
                    modifier = Modifier.size(width = 80.dp, height = 80.dp)
                )

                Spacer(modifier = Modifier.width(16.dp)) // Espaço entre a imagem e o texto
                Text(
                    text = "TinyDreamer",
                    style = TextStyle(
                        fontSize = 30.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = azul_confort,
                        fontFamily = FontFamily.Cursive
                    )
                )
            }
        }

        // Coluna centralizada
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.padding(top = 60.dp))

            // Card ajustado com largura aumentada
            Card(
                modifier = Modifier
                    .fillMaxWidth(0.9f) // Aumenta a largura para 90% da tela
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 16.dp)
                    .shadow(4.dp, shape = RoundedCornerShape(16.dp)),
                shape = RoundedCornerShape(16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .background(rose_confort) // Cor de fundo do Card
                        .fillMaxWidth() // Preenche o tamanho do Card
                        .padding(16.dp) // Padding interno do Card
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "💓 Som de Batimentos Cardíacos 💓",
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = marsala_confort,
                                fontFamily = FontFamily.Cursive,
                                textAlign = TextAlign.Center
                            )
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "O som suave e rítmico dos batimentos cardíacos traz uma sensação de conforto e segurança, como nos primeiros dias de vida.",
                            style = TextStyle(
                                fontSize = 16.sp,
                                color = Color.Black,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Center
                            )
                        )
                    }
                }
            }

            // Player de música dentro do Box
            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .border(
                        BorderStroke(2.dp, color = roxo_confort),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .clip(RoundedCornerShape(16.dp))
                    .background(color = rose_confort)
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = if (isPlaying) "🎵 Reproduzindo Som 🎵" else "⏸️ Som Pausado ⏸️",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = azul_confort,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Botão Tocar/Pausar
                    Button(
                        onClick = {
                            if (isPlaying) {
                                mediaPlayer.pause()
                            } else {
                                mediaPlayer.start()
                            }
                            isPlaying = !isPlaying
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (isPlaying) Color(0xFFEF5350) else Color(0xFF66BB6A),
                            contentColor = Color.White
                        ),
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(50.dp),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = if (isPlaying) "⏸️ Pausar" else "▶️ Tocar",
                            style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Medium)
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Botão Reiniciar
                    Button(
                        onClick = {
                            mediaPlayer.seekTo(0)
                            mediaPlayer.start()
                            isPlaying = true
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF42A5F5),
                            contentColor = Color.White
                        ),
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(50.dp),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = "🔁 Reiniciar Som",
                            style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Medium)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp)) // Espaço entre o player e outros componentes
        }
    }
}


@SuppressLint("RememberReturnType")
@Composable
fun Third_Music(
    navController: NavController? = null,
    innerPadding: PaddingValues = PaddingValues()
) {
    val context = LocalContext.current
    val mediaPlayer = remember {
        MediaPlayer.create(
            context,
            R.raw.ruido_branco
        )
    }
    var isPlaying by remember { mutableStateOf(false) }

    // Liberar recursos do MediaPlayer ao final
    DisposableEffect(Unit) {
        onDispose {
            mediaPlayer.release()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(R.drawable.tela_nuvens),
                contentScale = ContentScale.Crop
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 34.dp) // Margem lateral para alinhar à esquerda
        ) {
            Spacer(modifier = Modifier.height(95.dp)) // Ajuste a altura para descer a imagem

            // Row para organizar imagem e texto lado a lado
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically // Alinha o texto com a imagem
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_aplicativo),
                    contentDescription = "Logo Aplicativo",
                    modifier = Modifier.size(width = 80.dp, height = 80.dp)
                )

                Spacer(modifier = Modifier.width(16.dp)) // Espaço entre a imagem e o texto
                Text(
                    text = "TinyDreamer",
                    style = TextStyle(
                        fontSize = 30.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = azul_confort,
                        fontFamily = FontFamily.Cursive
                    )
                )
            }
        }

        // Coluna centralizada
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.padding(top = 60.dp))

            // Card ajustado com largura aumentada
            Card(
                modifier = Modifier
                    .fillMaxWidth(0.9f) // Aumenta a largura para 90% da tela
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 16.dp)
                    .shadow(4.dp, shape = RoundedCornerShape(16.dp)),
                shape = RoundedCornerShape(16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .background(rose_confort) // Cor de fundo do Card
                        .fillMaxWidth() // Preenche o tamanho do Card
                        .padding(16.dp) // Padding interno do Card
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "☁️ Ruído Branco da Serenidade ☁️",
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = marsala_confort,
                                fontFamily = FontFamily.Cursive,
                                textAlign = TextAlign.Center
                            )
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Deixe o som suave e constante do ruído branco trazer calma, como um abraço de nuvem macia.",
                            style = TextStyle(
                                fontSize = 16.sp,
                                color = Color.Black,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Center
                            )
                        )
                    }
                }
            }

            // Player de som dentro do Box
            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .border(
                        BorderStroke(2.dp, color = roxo_confort),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .clip(RoundedCornerShape(16.dp))
                    .background(color = rose_confort)
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = if (isPlaying) "🎶 Reproduzindo Som 🎶" else "⏸️ Som Pausado ⏸️",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = azul_confort,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Botão Tocar/Pausar
                    Button(
                        onClick = {
                            if (isPlaying) {
                                mediaPlayer.pause()
                            } else {
                                mediaPlayer.start()
                            }
                            isPlaying = !isPlaying
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (isPlaying) Color(0xFFEF5350) else Color(0xFF66BB6A),
                            contentColor = Color.White
                        ),
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(50.dp),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = if (isPlaying) "⏸️ Pausar" else "✨ Nuvem de Paz ✨",
                            style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Medium)
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Botão Reiniciar
                    Button(
                        onClick = {
                            mediaPlayer.seekTo(0)
                            mediaPlayer.start()
                            isPlaying = true
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF42A5F5),
                            contentColor = Color.White
                        ),
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(50.dp),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = "🔁 Reiniciar Som",
                            style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Medium)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp)) // Espaço entre o player e outros componentes
        }
    }
}


@Preview
@Composable
private fun PreviewTelaSplash() {
    ConteudoSplash(rememberNavController())
}

@Preview
@Composable
private fun PreviewStoryApp() {
    StoryApp(rememberNavController())

}

@Preview
@Composable
private fun PreviewMusica_Opcoes() {
    Musicas_Opcoes(rememberNavController())

}



