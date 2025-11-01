package com.example.input_pengguna

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FormDataDiri(modifier: Modifier
){
    var textNama by remember { mutableStateOf(value = "") }
    var textAlamat by remember { mutableStateOf(value="") }
    var textJK by remember { mutableStateOf(value = "") }
    var textStatus by remember { mutableStateOf("") }

    var nama by remember { mutableStateOf(value = "") }
    var alamat by remember { mutableStateOf(value = "") }
    var jenis by remember { mutableStateOf(value = "") }
    var status by remember { mutableStateOf("") }

    val gender: List<String> = listOf("Laki-Laki", "Perempuan")
    val statusKawin = listOf("Janda", "Lajang", "Duda")

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFFBA68C8), Color(0xFF9C27B0))
                )
            )
            .padding( bottom = 40.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF9C27B0))
                .padding(vertical = 40.dp)
        ) {
            Text(
                text = "Formulir Pendaftaran",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        ElevatedCard(
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(10.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_medium)),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(text = "NAMA LENGKAP", fontWeight = FontWeight.SemiBold)
                OutlinedTextField(
                    value = textNama,
                    singleLine = true,
                    shape = MaterialTheme.shapes.large,
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = "Isian nama lengkap") },
                    onValueChange = { textNama = it }
                )

                Row {
                    gender.forEach{ item ->
                        Row(modifier = Modifier.selectable(
                            selected = textJK == item,
                            onClick = {textJK = item}
                        ), verticalAlignment = Alignment.CenterVertically){
                            RadioButton(
                                selected = textJK == item,
                                onClick =  {
                                    textJK = item
                                })
                            Text(text = item)
                        }
                    }

                    Text(text = "STATUS PERKAWINAN", fontWeight = FontWeight.SemiBold)
                    statusKawin.forEach { item ->
                        Row(
                            modifier = Modifier
                                .selectable(
                                    selected = textStatus == item,
                                    onClick = { textStatus = item }
                                ),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = textStatus == item,
                                onClick = { textStatus = item }
                            )
                            Text(text = item)
                        }
                    }

                    Text(text = "ALAMAT", fontWeight = FontWeight.SemiBold)
                    OutlinedTextField(
                        value = textAlamat,
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text(text = "Alamat") },
                        onValueChange = { textAlamat = it }
                    )

                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9C27B0)),
                        enabled = textNama.isNotEmpty() && textAlamat.isNotEmpty(),
                        onClick = {
                            nama = textNama
                            jenis = textJK
                            alamat = textAlamat
                            status = textStatus
                        }
                    ) {
                        Text(
                            text = stringResource(id = R.string.submit),
                            color = Color.White
                        )
                    }
                }
            }


            if (nama.isNotEmpty()) {
                Spacer(modifier = Modifier.height(20.dp))
                ElevatedCard(
                    elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.Black),
                    modifier = Modifier
                        .width(300.dp)
                        .height(120.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(10.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(text = "Nama: $nama", color = Color.White)
                        Text(text = "Gender: $jenis", color = Color.White)
                        Text(text = "Status: $status", color = Color.White)
                        Text(text = "Alamat: $alamat", color = Color.White)
                    }
                }
            }
        }
    }
}
