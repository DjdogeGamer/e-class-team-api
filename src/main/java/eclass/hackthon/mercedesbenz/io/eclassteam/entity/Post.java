package eclass.hackthon.mercedesbenz.io.eclassteam.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a post with content, tags, and a user who created using JPA annotations.
 */
@Entity
@Getter
@Setter
@Table(name = "post")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String content;

	@JoinColumn(name = "user_id")
	@ManyToOne
	private User user;

	private String deeplink;

	@Column(nullable = false)
	private String title;
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "posts_tags",
			joinColumns = {@JoinColumn(name = "post_id", nullable = false, updatable = false)},
			inverseJoinColumns = {@JoinColumn(name = "tag_id", nullable = false, updatable = false)}
	)
	private Set<Tag> tags = new HashSet<>();

	private String permalink;

	@ManyToMany(mappedBy = "likedPosts")
	private Set<User> likedByUsers = new HashSet<>();

	public String getDeeplink() {
		return deeplink;
	}



	public void setDeeplink(String deeplink) {
		this.deeplink = deeplink;
	}
	public void setPermalink(String permalink) {
		String token = permalink.toLowerCase().replace("\n", " ").replaceAll("[^a-z\\d\\s]", " ");
		this.permalink = StringUtils.arrayToDelimitedString(StringUtils.tokenizeToStringArray(token, " "), "-");
	}

}