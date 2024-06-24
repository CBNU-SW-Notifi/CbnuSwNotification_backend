package com.CbnuSwNotification.CbnuSwNotification.test.entity

import com.CbnuSwNotification.CbnuSwNotification.SpringTestSetting
import com.CbnuSwNotification.CbnuSwNotification.application.repository.postRepository.PostRepository
import com.CbnuSwNotification.CbnuSwNotification.fixture.PostFixture
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import java.time.LocalDateTime

class CbnuSoftwareJobHuntPostEntityTest(
    @Autowired private val postRepository: PostRepository,
):SpringTestSetting(){

    @Test
    fun savePost(){
        val post = PostFixture.createPost()
        val id = postRepository.save(post)

        Assertions.assertThat(postRepository.findById(id)).isSameAs(post)
        Assertions.assertThat(post.id).isNotNull()
        Assertions.assertThat(post.saveTime).isNotNull()
        Assertions.assertThat(post.saveTime).isBefore(LocalDateTime.now())
    }

    @Test
    fun saveLargePost(){
        val str =
            "인간의 역사는 수많은 도전과 응전, 성공과 실패, 발견과 발명, 전쟁과 평화, 예술과 과학, 철학과 문학, 사회적 진보와 퇴보, 경제적 번영과 쇠퇴 등 무수한 사건과 변화들로 이루어져 있으며, 이러한 모든 요소들은 각기 서로 얽히고설켜 현대 사회의 복잡한 구조와 문화를 형성하는 데 중요한 역할을 해왔다는 점에서, 이를 이해하고 분석하는 것은 단순히 과거의 일들을 회상하는 것을 넘어서 현재와 미래를 예측하고 준비하는 데 있어서도 매우 중요한 의미를 지닌다고 할 수 있다. 이러한 역사적 맥락 속에서 특히 눈여겨볼 만한 것은 기술의 발전과 그로 인한 사회적 변화들인데, 산업 혁명 이후 급격히 가속화된 기술 발전은 인간의 삶의 방식을 근본적으로 변화시켰고, 이는 곧 전 세계적인 경제 구조의 재편과 인구 이동, 도시화, 그리고 새로운 형태의 사회 문제들을 야기하였다. 예를 들어, 증기 기관의 발명은 생산성을 극적으로 향상시켜 공업화를 촉진시켰을 뿐만 아니라, 철도와 증기선의 발전을 통해 물리적 거리를 좁히고 지역 간의 교류를 활성화시켰다. 이는 도시로의 인구 집중을 초래하여 대도시가 형성되고, 그 결과 주택 부족, 공해, 노동 착취 등 다양한 도시 문제들이 대두되었으며, 이러한 문제들을 해결하기 위한 사회적, 정치적, 경제적 노력이 필요하게 되었다. 또한, 전기의 발명과 보급은 가정과 산업 현장에서의 혁신을 가져와 생활의 편리성을 증대시켰고, 통신 기술의 발전은 전 세계를 하나로 연결하여 정보의 즉각적인 교환을 가능하게 함으로써 지식과 문화의 전파 속도를 비약적으로 증가시켰다. 더 나아가, 20세기 중반 이후의 컴퓨터와 인터넷의 발달은 정보화 사회를 열어 새로운 경제 모델과 비즈니스 기회를 창출하였으며, 이는 오늘날 4차 산업 혁명의 기반이 되고 있다. 그러나 이러한 기술 발전은 긍정적인 영향만을 미친 것은 아니며, 정보 격차와 개인정보 보호 문제, 그리고 기술 의존으로 인한 인간 소외 등의 부작용도 초래하였다. 따라서 현대 사회는 기술 발전의 혜택을 최대한 누리면서도 그로 인한 부작용을 최소화하기 위한 균형 잡힌 접근이 필요하다. 이를 위해서는 기술 윤리의 확립과 지속 가능한 발전을 위한 국제적 협력이 요구되며, 동시에 각국의 정책 입안자들은 기술 발전이 사회 전반에 걸쳐 고르게 혜택을 미칠 수 있도록 신중하고 철저한 계획을 수립해야 한다. 또한, 교육 시스템 역시 변화하는 기술 환경에 맞추어 개편되어야 하며, 이는 단순히 기술 사용 능력을 기르는 것을 넘어서, 비판적 사고와 창의성을 키우고, 사회적 책임감을 함양하는 방향으로 나아가야 할 것이다. 이러한 노력들은 모두 결국 인간의 존엄성과 행복을 추구하는 데 그 궁극적인 목표가 있으며, 이를 위해 우리는 과거의 교훈을 되새기고, 현재의 문제를 직시하며, 미래를 향한 비전을 제시할 수 있어야 할 것이다. 인간은 끊임없이 도전하고 적응하며, 변화를 수용하는 존재이기에, 앞으로도 우리는 새로운 기술과 환경 변화에 대응하면서 더 나은 사회를 만들어 나갈 수 있을 것이라 확신한다."
        val post = PostFixture.createPost(str)
        val id = postRepository.save(post)
        Thread.sleep(10)


        val findPost = postRepository.findById(id)!!


        Assertions.assertThat(findPost).isSameAs(post)
        Assertions.assertThat(findPost.id).isNotNull()
        Assertions.assertThat(findPost.saveTime).isNotNull()
        Assertions.assertThat(findPost.saveTime).isBefore(LocalDateTime.now())
        Assertions.assertThat(findPost.content).isEqualTo(str)
    }

}