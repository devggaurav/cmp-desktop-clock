package com.gc.desktopclock.presentation.common

import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.Font
import androidx.compose.ui.text.font.FontFamily
import desktopclock.composeapp.generated.resources.Itim_Regular
import desktopclock.composeapp.generated.resources.Overlock_Black
import desktopclock.composeapp.generated.resources.Overlock_Bold
import desktopclock.composeapp.generated.resources.Overlock_BoldItalic
import desktopclock.composeapp.generated.resources.Overlock_Italic
import desktopclock.composeapp.generated.resources.Overlock_Regular
import desktopclock.composeapp.generated.resources.Pacifico_Regular
import desktopclock.composeapp.generated.resources.Res


//
// Created by Code For Android on 28/02/25.
// Copyright (c) 2025 CFA. All rights reserved.
//

@Composable
fun ItimFontFamily() = FontFamily(Font(Res.font.Itim_Regular))

@Composable
fun PacificoFontFamily() = FontFamily(Font(Res.font.Pacifico_Regular))


@Composable
fun OverlockFontFamily(fontType: FontType = FontType.NORMAL) = when(fontType){

    FontType.NORMAL -> FontFamily(Font(Res.font.Overlock_Regular))
    FontType.ITALIC -> FontFamily(Font(Res.font.Overlock_Italic))
    FontType.BOLD -> FontFamily(Font(Res.font.Overlock_Bold))
    FontType.BOLD_ITALIC -> FontFamily(Font(Res.font.Overlock_BoldItalic))
    FontType.SEMI_BOLD -> FontFamily(Font(Res.font.Overlock_Black))
}

