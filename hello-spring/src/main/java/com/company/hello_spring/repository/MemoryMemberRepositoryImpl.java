package com.company.hello_spring.repository;

import com.company.hello_spring.domain.Member;

import java.util.*;

public class MemoryMemberRepositoryImpl implements MemberRepository {

    // 'store'는 회원(Member) 객체를 저장하는 HashMap입니다.
// Long 타입의 키를 사용하여 각 회원에 대한 고유 식별자를 관리합니다.
    private static Map<Long, Member> store = new HashMap<>();

    // 'sequence'는 회원(Member) 객체에 대한 고유한 ID를 생성하기 위한 시퀀스 번호입니다.
// 각 새로운 회원을 추가할 때마다 이 값을 증가시켜 고유한 ID를 부여합니다.
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return null;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
