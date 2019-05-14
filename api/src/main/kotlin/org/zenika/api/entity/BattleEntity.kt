package org.zenika.api.entity

import org.zenika.core.BattleStatus
import org.zenika.core.Pokemon

data class BattleEntity(var id: String, var battleStatus: BattleStatus = BattleStatus.TO_START, var winner: Pokemon? = null)
