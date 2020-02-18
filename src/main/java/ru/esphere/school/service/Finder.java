package ru.esphere.school.service;

import ru.esphere.school.data.Member;
import ru.esphere.school.data.MembersGroup;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Finder {
    /**
     * Поиск групп людей старше определенного возраста.
     *
     * @param groups    группы
     * @param targetAge возраст для поиска
     * @return список имен групп из списка групп старше возраста targetAge
     */
    public Set<Object> findOldMembers(List<MembersGroup> groups, int targetAge) {
        return groups.stream()
                .map(MembersGroup::getMembers)
                .flatMap(Collection::stream)
                .filter(o -> o.getAge() > targetAge)
                .map(Member::getName)
                .collect(Collectors.toSet());
    }
}
