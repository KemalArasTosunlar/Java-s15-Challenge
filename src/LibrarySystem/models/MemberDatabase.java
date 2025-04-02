package LibrarySystem.models;

import java.util.ArrayList;
import java.util.List;

public class MemberDatabase {
    private List<MemberRecord> members;


    public MemberDatabase() {
        this.members = new ArrayList<>();
    }

    public void addMember(MemberRecord member) {
        members.add(member);
        System.out.println("Üye veri tabanına üye eklendi: " + member.getName() + " (ID: " + member.getMemberId() + ")");
    }

    public MemberRecord searchMemberByName(String name) {
        for (MemberRecord member : members) {
            if (member.getName().equalsIgnoreCase(name)) {
                return member;
            }
        }
        return null;
    }

    public MemberRecord searchMemberById(int memberId) {
        for (MemberRecord member : members) {
            if (member.getMemberId() == memberId) {
                return member;
            }
        }
        return null;
    }

    public List<MemberRecord> getAllMembers() {
        return new ArrayList<>(members); // Kopyayı döndürerek dışarıdan değişiklik yapılmasını engelle
    }

}