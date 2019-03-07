package org.zenika.api.entity

import org.zenika.core.BattleStatus
import org.zenika.core.Pokemon

class BattleEntity {
    lateinit var id: String
    lateinit var battleStatus: BattleStatus
    var winner: Pokemon? = null
}
