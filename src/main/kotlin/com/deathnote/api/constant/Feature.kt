package com.deathnote.api.constant

enum class Feature(val key: String, val weight: Int) {
    KDA("kda", 1767),
    TOTAL_DAMAGE_DEALT_TO_CHAMPIONS("totalDamageDealtToChampions", 1165);

    companion object {
        fun getFeatureOf(key: String): Feature? {
            values().forEach {
                if (it.key === key) {
                    return it
                }
            }
            return null
        }
    }
}