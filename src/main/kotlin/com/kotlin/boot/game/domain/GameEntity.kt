package com.kotlin.boot.game.domain

import com.kotlin.boot.global.dto.BaseDomain
import com.kotlin.boot.user.domain.PlayGameUser
import javax.persistence.*

@Entity
@Table(name = "PLAY_GAME_INFO")
data class GameEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "playGameIdGenerator")
    @SequenceGenerator(name = "playGameIdGenerator", sequenceName = "PLAY_GAME_HISTORY_SEQ", allocationSize = 1)
    var id: Long? = null,
    @Column(name = "PLAYER_PHONE_NUMBER")
    val phoneNumber: String,
    @Column(name = "PLAYER_NICK_NAME")
    val nickName: String,
    @Column(name = "GAME_NUMBER")
    val gameNumber: String,
    @Column(name = "USER_ID")
    val userId: String,
    @Column(name = "GAME_ROUND")
    val playRound: Long
) : BaseDomain() {
    companion object {
        fun of(
            playGameUserInfo: PlayGameUser,
            gameNumber: String,
            playRound: Long
        ) = GameEntity(
            null,
            playGameUserInfo.phoneNumber,
            playGameUserInfo.nickName,
            gameNumber,
            playGameUserInfo.userId,
            playRound
        )
    }
}
