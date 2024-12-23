package com.oktaygenc.bipapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.oktaygenc.bipapp.R
import com.oktaygenc.bipapp.ui.component.IconButtonWithText
import com.oktaygenc.bipapp.ui.component.MessageItem
import com.oktaygenc.bipapp.ui.theme.AnaColor
import com.oktaygenc.bipapp.ui.theme.SecondColor
import com.oktaygenc.bipapp.ui.theme.TextBlack
import com.oktaygenc.bipapp.ui.theme.TextRed
import com.oktaygenc.bipapp.ui.theme.TextWhite
import com.oktaygenc.bipapp.ui.theme.roboto

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val tabs = listOf(
        stringResource(R.string.chats),
        stringResource(R.string.services),
        stringResource(R.string.channels),
    )
    var selectedIndex by remember { mutableIntStateOf(0) }

    Scaffold(topBar = {
        Column {
            TopAppBar(modifier = Modifier.height(50.dp),
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = AnaColor,
                    titleContentColor = TextWhite,
                    actionIconContentColor = TextWhite
                ),
                navigationIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.bipicon),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .size(48.dp)
                    )
                },
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = stringResource(R.string.messagestop),
                            fontFamily = roboto,
                            fontSize = 20.sp,
                            modifier = Modifier.padding(start = 40.dp, top = 10.dp)
                        )
                    }
                },
                actions = {
                    Row(
                        modifier = Modifier.fillMaxHeight(), horizontalArrangement = Arrangement.End
                    ) {
                        IconButton(onClick = { }) {
                            Icon(
                                painterResource(R.drawable.search),
                                contentDescription = "",
                                Modifier.size(30.dp)
                            )
                        }
                        IconButton(onClick = { }) {
                            Icon(
                                painterResource(R.drawable.icfilter),
                                contentDescription = "",
                                Modifier.size(20.dp)
                            )
                        }
                    }
                })

            TabRow(selectedTabIndex = selectedTabIndex,
                containerColor = TextWhite,
                contentColor = SecondColor,
                modifier = Modifier.fillMaxWidth(),
                indicator = { tabPositions ->
                    if (selectedTabIndex < tabPositions.size) {
                        Box(
                            modifier = Modifier
                                .tabIndicatorOffset(tabPositions[selectedTabIndex])
                                .height(3.dp)
                                .background(SecondColor)
                        )
                    }
                }) {
                tabs.forEachIndexed { index, title ->
                    Tab(selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index },
                        text = {
                            Text(
                                text = title, fontSize = 15.sp, fontWeight = FontWeight.Bold
                            )
                        })
                }
            }
        }
    }, bottomBar = {
        BottomAppBar(
            modifier = Modifier.fillMaxWidth(), containerColor = TextWhite, contentColor = TextBlack
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButtonWithText(iconRes = R.drawable.status,
                    text = stringResource(R.string.status),
                    isSelected = selectedIndex == 0,
                    onClick = { selectedIndex = 0 })
                IconButtonWithText(iconRes = R.drawable.message,
                    text = stringResource(R.string.messagesbottom),
                    isSelected = selectedIndex == 1,
                    onClick = { selectedIndex = 1 })
                IconButtonWithText(iconRes = R.drawable.call,
                    text = stringResource(R.string.calls),
                    isSelected = selectedIndex == 2,
                    onClick = { selectedIndex = 2 })
                IconButtonWithText(iconRes = R.drawable.discover,
                    text = stringResource(R.string.discover),
                    isSelected = selectedIndex == 3,
                    onClick = { selectedIndex = 3 })
                IconButtonWithText(iconRes = R.drawable.more,
                    text = stringResource(R.string.more),
                    isSelected = selectedIndex == 4,
                    onClick = { selectedIndex = 4 })
            }
        }
    }, content = { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(TextWhite)
        ) {
            items(10) {
                MessageItem(
                    R.drawable.sampleimage1,
                    "Elif Hanım",
                    "Çok geçmiş Oktay şuan nasılsın?",
                    "10:30",
                    true
                )
                MessageItem(R.drawable.sampleimage8,
                    "Babam",
                    "Gece geç kalma!",
                    "17:55",
                    true)
                MessageItem(
                    R.drawable.sampleimage2,
                    "Kübra",
                    "Ders notlarını paylaşabilir misin?",
                    "09:15",
                    true
                )
                MessageItem(
                    R.drawable.sampleimage3,
                    "Ayşe Müdür",
                    "Toplantı saatini değiştirdim",
                    "12:45",
                    true
                )
                MessageItem(
                    R.drawable.sampleimage9,
                    "Canım",
                    "Makarna,süt ve ekmek unutma <3",
                    "22:45",
                    true
                )
                MessageItem(
                    R.drawable.sampleimage4,
                    "Mustafa Bey",
                    "Yarın buluşalım mı?",
                    "17:20",
                    false
                )
                MessageItem(
                    R.drawable.sampleimage5,
                    "Zeynep Abla",
                    "Akşam gelirken yumurta al!",
                    "11:00",
                    false
                )
                MessageItem(
                    R.drawable.sampleimage6,
                    "Ali",
                    "Bugünkü antrenman iptal",
                    "14:30",
                    false
                )
                MessageItem(
                    R.drawable.sampleimage10,
                    "Kardeşim",
                    "İş Görüşmem olumlu geçti!",
                    "15:05",
                    false
                )
                MessageItem(
                    R.drawable.sampleimage7,
                    "Can Bey",
                    "Proje sunumu hazır mı?",
                    "16:10",
                    false
                )
            }
        }
    }, floatingActionButton = {
        Column(
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.padding(bottom = 8.dp, end = 3.dp)

        ) {
            FloatingActionButton(
                onClick = { }, shape = CircleShape, containerColor = TextRed
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.alarm),
                    contentDescription = "",
                    tint = TextWhite
                )
            }

            FloatingActionButton(
                onClick = { }, shape = CircleShape, containerColor = AnaColor
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.message),
                    contentDescription = "",
                    tint = TextWhite
                )
            }
        }
    })
}

